package com.example.julio.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.julio.model.Conta;

/*
 * this is the interfece jpa than when compiled,  will transform to
 *  a concrete class
 * implemented with  hibernet.
 */

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    
}
