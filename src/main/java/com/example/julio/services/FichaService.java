package com.example.julio.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import java.util.ArrayList;
import com.example.julio.repositories.FichaRepository;
import com.example.julio.model.Ficha;
import com.example.julio.model.Conta;

@Service
public class FichaService {
    @Autowired
    private FichaRepository fichaRepository;

    public List<Ficha> list() {
        return this.fichaRepository.findAll();
    }

    public void save(Ficha ficha) {
       List<Conta> contas = ficha.getContas();
       List<Conta> contaList = new ArrayList();

       for(Conta conta:contas){
            conta.setFicha(ficha);
            contaList.add(conta);
       }

       ficha.setContas(contaList);
       this.fichaRepository.save(ficha);
    }

    /*public void editar(Ficha ficha) {
        this.fichaRepository.save(ficha);
    }*/

    public void excluir(Long id) {
        this.fichaRepository.deleteById(id);
    }
}
