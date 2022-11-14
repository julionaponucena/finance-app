package com.example.julio.dto;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import java.util.stream.Collectors;
import com.example.julio.model.Conta;
import com.example.julio.model.Ficha;

@Getter
@Setter
public class FichaDto {
    private Long id;
    private String titulo;
    private Date data;
    private Float result;
    private List<ContaDto> contas;

    public FichaDto (Ficha ficha){
        this.id = ficha.getId();
        this.titulo = ficha.getTitulo();
        this.data = ficha.getData();
        this.result = ficha.getResult();
        this.contas = ficha.getContas().stream().map(ContaDto::new).collect(Collectors.toList());
    }
}
