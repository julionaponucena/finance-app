package com.example.julio;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.julio.repositories.UserRepository;
import com.example.julio.model.Cliente;
import com.example.julio.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Cliente> listUser(){
        
        return userService.listar() ;
    }
    
}