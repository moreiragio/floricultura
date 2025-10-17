package com.floricultura.service;

import com.floricultura.model.Usuario;
import com.floricultura.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public void salvar(Usuario usuario) {
        repository.save(usuario);
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
