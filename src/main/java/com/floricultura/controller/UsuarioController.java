package com.floricultura.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.floricultura.model.Usuario;
import com.floricultura.service.UsuarioService;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Página de cadastro
    @GetMapping("/usuarios/cadastro")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro"; // nome do HTML em templates
    }

    // Recebe o POST do formulário
    @PostMapping("/usuarios")
    public String cadastrarUsuario(@ModelAttribute Usuario usuario, Model model) {
        // Verifica se email já existe
        if (usuarioService.emailExiste(usuario.getEmail())) {
            model.addAttribute("erro", "Este e-mail já está cadastrado!");
            return "cadastro";
        }

        // Salva no banco
        usuarioService.salvarUsuario(usuario);
        model.addAttribute("sucesso", "Cadastro realizado com sucesso!");
        return "login"; // redireciona para página de login
    }
}
