package com.example.julio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.julio.model.Usuario;
import com.example.julio.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public void create(@RequestBody Usuario user){
        this.usuarioService.save(user);
    }

    @PutMapping
    public void alterar (@RequestBody Usuario user){
        this.usuarioService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.usuarioService.delete(id);
    }
}
