package com.example.julio.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.julio.services.ContaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.julio.model.Conta;

@RestController
@RequestMapping("/contas")
public class ContaController {
    
    @Autowired
    private ContaService contaService;


    @GetMapping
    public List<Conta> listar (){
        return contaService.listar();
    }

    @PostMapping
    public void postConta(@RequestBody Conta conta){
        contaService.inserir(conta);
    }

}
