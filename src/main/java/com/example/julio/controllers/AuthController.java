package com.example.julio.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.julio.dto.UserRequest;
import com.example.julio.services.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @Autowired
    AuthenticationManager authenticationManager;
    
    @PostMapping("/Login")
    public String login (@RequestBody UserRequest user )throws AuthenticationException {
        Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
        return this.authService.generateToken(authentication);
    }

    
}
