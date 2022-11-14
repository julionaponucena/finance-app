package com.example.julio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.julio.model.Usuario;
import com.example.julio.repositories.UsuarioRepository;
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void save(Usuario usuario){
        this.usuarioRepository.save(usuario);
    }

    public Usuario findOneById(Long id){
        Optional<Usuario> user = this.usuarioRepository.findById(id);

        return user.get();
    }

    public void delete (Long id){
        this.usuarioRepository.deleteById(id);
    }
}
