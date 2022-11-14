package com.example.julio.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.julio.model.Usuario;

@Repository
public interface UsuarioRepository  extends JpaRepository <Usuario, Long> {
    
}
