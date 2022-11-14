package com.example.julio.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Data

@Entity
public class Ficha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "ficha")
    
    private List<Conta> contas;
    
    @Column
    private float result;

    @ManyToOne
    private Usuario usuario;

    @JsonManagedReference
    public List<Conta> getContas(){
        return this.contas;
    }
}
