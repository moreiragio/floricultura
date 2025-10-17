package com.floricultura.controller;

import com.floricultura.model.Flor;
import com.floricultura.service.FlorService;
import com.floricultura.service.FuncionarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/flor")
public class FlorController {

    private final FlorService service;
    private final FuncionarioService funcionarioService;

    public FlorController(FlorService service, FuncionarioService funcionarioService) {
        this.service = service;
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("flores", service.listarTodos());
        return "flor/listarFlor";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("flor", new Flor());
        model.addAttribute("funcionarios", funcionarioService.listarTodos());
        return "flor/cadastrarFlor";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Flor flor) {
        service.salvar(flor);
        return "redirect:/flor";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Flor flor = service.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Flor inválida"));
        model.addAttribute("flor", flor);
        model.addAttribute("funcionarios", funcionarioService.listarTodos());
        return "flor/cadastrarFlor";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/flor";
    }
}
