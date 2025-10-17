package com.floricultura.controller;

import com.floricultura.model.Usuario;
import com.floricultura.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/cadastrarUsuario";
    }


    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Usuario usuario, Model model) {
        service.salvar(usuario);
        model.addAttribute("sucesso", true);
        model.addAttribute("usuario", new Usuario());
        return "usuario/cadastrarUsuario";
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", service.listarTodos());
        return "usuario/listarUsuarios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Usuario> usuarioOpt = service.buscarPorId(id);
        if (usuarioOpt.isPresent()) {
            model.addAttribute("usuario", usuarioOpt.get());
            return "usuario/editarUsuario";
        } else {
            return "redirect:/usuarios";
        }
    }
    @PostMapping("/atualizar")
    public String atualizar(@ModelAttribute Usuario usuario) {
        service.atualizar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/usuarios";
    }
}
