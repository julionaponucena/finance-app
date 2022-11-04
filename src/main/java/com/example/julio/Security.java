package com.example.julio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

// this is the class setup  to the project
@Configuration
public class Security {
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
        /*
            this config generate an csfr token for the cliente acess post 
            methods with security 

         */
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and().authorizeRequests().anyRequest().authenticated().and().httpBasic();

        return http.build();
    }
}
