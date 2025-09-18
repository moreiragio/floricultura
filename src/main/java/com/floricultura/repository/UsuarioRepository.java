package com.floricultura.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.floricultura.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
}
