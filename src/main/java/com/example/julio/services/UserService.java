package com.example.julio.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.julio.model.Cliente;
import com.example.julio.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<Cliente> listar (){
        return userRepository.findAll();
    }

}
