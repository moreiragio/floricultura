package com.floricultura.service;

import com.floricultura.model.Usuario;
import com.floricultura.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(Usuario u) { return usuarioRepository.save(u); }
    public Usuario get(Long id) { return usuarioRepository.findById(id).orElse(null); }
    public List<Usuario> list() { return usuarioRepository.findAll(); }
    public void delete(Long id) { usuarioRepository.deleteById(id); }
}