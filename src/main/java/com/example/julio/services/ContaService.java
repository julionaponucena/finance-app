package com.example.julio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.julio.model.Conta;
import com.example.julio.repositories.ContaRepository;

import java.util.List;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public void inserir(Conta conta){
        contaRepository.save(conta);
    }

    public List<Conta> listar (){
        return contaRepository.findAll();
    }
}
