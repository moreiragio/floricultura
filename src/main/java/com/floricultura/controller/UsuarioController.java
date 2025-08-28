package com.floricultura.controller;

import com.floricultura.model.Usuario;
import com.floricultura.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario criar(@RequestBody Usuario u) { return usuarioService.save(u); }

    @GetMapping
    public List<Usuario> listar() { return usuarioService.list(); }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) { return usuarioService.get(id); }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario u) {
        u.setId(id);
        return usuarioService.save(u);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) { usuarioService.delete(id); }
}