package com.example.julio.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.julio.model.Cliente;


@Repository
public interface UserRepository extends JpaRepository<Cliente , Long> {
  //public User findUserByName(String name);
   
}
 