package com.floricultura.repository;

import com.floricultura.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.floricultura.model.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    boolean existsByTipoUsuario(String tipoUsuario);

    Optional<Usuario> findByEmailAndSenha(String email, String senha);

}
