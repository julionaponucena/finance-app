package com.example.julio.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.example.julio.model.Ficha;

@Repository
public interface FichaRepository extends JpaRepository <Ficha, Long> {

    
}