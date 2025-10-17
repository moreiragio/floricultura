package com.floricultura.controller;

import com.floricultura.model.Funcionario;
import com.floricultura.service.FuncionarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("funcionarios", service.listarTodos());
        return "funcionario/listar";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "funcionario/formFuncionario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Funcionario funcionario) {
        service.salvar(funcionario);
        return "redirect:/funcionarios";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Funcionario funcionario = service.buscarPorId(id).orElseThrow();
        model.addAttribute("funcionario", funcionario);
        return "funcionario/formFuncionario";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/funcionarios";
    }
}
