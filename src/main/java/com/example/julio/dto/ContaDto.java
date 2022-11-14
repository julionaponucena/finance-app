package com.example.julio.dto;

import com.example.julio.model.Conta;

public class ContaDto {
    private Long id;
    private String nome;
    private boolean isDebito;
    private float valor;

    public ContaDto(Conta conta){
        this.id = conta.getId();
        this.nome = conta.getNome();
        this.isDebito = conta.isDebito();
        this.valor = conta.getValor();
    }
}
