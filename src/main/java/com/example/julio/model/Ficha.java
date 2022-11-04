package com.example.julio.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import lombok.Data;

@Data
@Entity
public class Ficha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column
    private Date data;

    @OneToMany(mappedBy = "ficha")
    private List<Conta> contas;
}
