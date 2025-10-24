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

        // Validar duplicidade
        if(service.existeEmail(funcionario.getEmail())) {
            model.addAttribute("erro", "Email já cadastrado!");
            model.addAttribute("funcionario", funcionario);
            return "admin/paginaAdmin";
        }
        if(service.existeCpf(funcionario.getCpf())) {
            model.addAttribute("erro", "CPF já cadastrado!");
            model.addAttribute("funcionario", funcionario);
            return "admin/paginaAdmin";
        }
        if(service.existeTelefone(funcionario.getTelefone())) {
            model.addAttribute("erro", "Telefone já cadastrado!");
            model.addAttribute("funcionario", funcionario);
            return "admin/paginaAdmin";
        }

        service.salvar(funcionario);
        return "redirect:/admin/paginaAdmin?sucesso=true";
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
        return "admin/paginaAdmin";
    }
}
