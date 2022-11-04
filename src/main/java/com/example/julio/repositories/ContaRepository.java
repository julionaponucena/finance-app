package com.example.julio.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.julio.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    
}
