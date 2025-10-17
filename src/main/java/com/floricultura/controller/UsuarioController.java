package com.floricultura.controller;

import com.floricultura.model.Usuario;
import com.floricultura.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", service.listarTodos());
        return "usuario/perfilUsuario";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/cadastrarUsuario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Usuario usuario) {
        service.salvar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Usuario usuario = service.buscarPorId(id).orElseThrow();
        model.addAttribute("usuario", usuario);
        return "usuario/editarUsuario";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/usuarios";
    }
}
