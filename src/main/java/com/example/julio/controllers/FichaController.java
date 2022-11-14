package com.example.julio.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.julio.model.Ficha;
import com.example.julio.services.FichaService;

@RestController
public class FichaController {
    @Autowired
    FichaService fichaService;

    @GetMapping
    List<Ficha> listFicha () {
        return this.fichaService.list();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    void postFicha (@RequestBody Ficha ficha) {
        this.fichaService.save(ficha);
    }

    @PutMapping
    void editFicha (@RequestBody Ficha ficha){
        
    }

    @DeleteMapping("/{id}")
    void excluir(@PathVariable Long id){
        this.fichaService.excluir(id);
    }
    
}
