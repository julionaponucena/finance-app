package com.example.julio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jose.jwk.gen.JWKGenerator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.JWKGenerator;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
// this is the class setup  to the project
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class Security {

    private RSAKey rsaKey;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(); 
    }

    @Bean
    public AuthenticationManager authManager(UserDetailsService userDetailsService) {
        var authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        return new ProviderManager(authProvider);
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
        /*
            this config generate an csfr token for the cliente acess post 
            methods with security 

         */
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).
        and().authorizeRequests(
            auth -> auth 
            .mvcMatchers("/auth").permitAll().
            anyRequest().authenticated()
        ).formLogin().loginPage("/auth").usernameParameter("email");
        
        
        /* .and().antMatcher("/**").authorizeRequests()
        .antMatchers(new String[]{"/", "/not-restricted"}).permitAll()
        .anyRequest().authenticated().and().oauth2Login()*/;

        return http.build();
    }

    
    /**
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername("dvega")
                        .password("{noop}password")
                        .authorities("read")
                        .build()
        );
    }

    @Bean
    public JWKSource<SecurityContext> jwkSource() {
        RSAKeyGenerator rsa = new RSAKeyGenerator(3650);
        try{
            rsaKey = rsa.generate();
        }catch(Exception ex){
            throw new RuntimeException("RSA ERROR");
        }
        JWKSet jwkSet = new JWKSet(rsaKey);
        return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);
    }
    @Bean
    JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwks) {
        return new NimbusJwtEncoder(jwks);
    }

    @Bean
    JwtDecoder jwtDecoder() throws JOSEException {
         return NimbusJwtDecoder.withPublicKey(rsaKey.toRSAPublicKey()).build();
    }
    
}
