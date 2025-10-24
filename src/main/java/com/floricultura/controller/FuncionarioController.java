package com.floricultura.controller;

import com.floricultura.model.Funcionario;
import com.floricultura.service.FuncionarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }


    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "admin/cadastrarFuncionario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Funcionario funcionario, Model model) {
        try {
            service.salvar(funcionario);
            model.addAttribute("sucesso", true);
            return "admin/paginaAdmin";
        } catch (Exception e) {
            model.addAttribute("erro", "Erro ao salvar funcionário. Verifique os campos.");
            return "admin/paginaAdmin";
        }
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
