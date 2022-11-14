package com.example.julio.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Data
@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String nome;

    @Column(columnDefinition="boolean default 'true'")
    private boolean isDebito;

    @Column
    private float valor;

    @ManyToOne
    private Ficha ficha;

    @JsonBackReference
    public Ficha getFicha(){
        return this.ficha;
    }
}
