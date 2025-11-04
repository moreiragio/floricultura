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
    public String listarFuncionarios(Model model) {
        model.addAttribute("funcionarios", service.listarTodos());
        return "admin/paginaAdmin";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "admin/cadastrarFuncionario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Funcionario funcionario, Model model) {

        if (service.existeEmail(funcionario.getEmail())) {
            model.addAttribute("erro", "Email já cadastrado!");
            model.addAttribute("funcionario", funcionario);
            return "admin/cadastrarFuncionario";
        }
        if (service.existeCpf(funcionario.getCpf())) {
            model.addAttribute("erro", "CPF já cadastrado!");
            model.addAttribute("funcionario", funcionario);
            return "admin/cadastrarFuncionario";
        }
        if (service.existeTelefone(funcionario.getTelefone())) {
            model.addAttribute("erro", "Telefone já cadastrado!");
            model.addAttribute("funcionario", funcionario);
            return "admin/cadastrarFuncionario";
        }

        service.salvar(funcionario);
        return "redirect:/funcionarios";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Funcionario funcionario = service.buscarPorId(id).orElseThrow();
        model.addAttribute("funcionario", funcionario);
        return "admin/editarFuncionario";
    }

    @PostMapping("/atualizar")
    public String atualizar(@ModelAttribute Funcionario funcionario, Model model) {
        try {
            service.atualizar(funcionario);
            return "redirect:/funcionarios";
        } catch (Exception e) {
            model.addAttribute("erro", "Erro ao atualizar funcionário: " + e.getMessage());
            model.addAttribute("funcionario", funcionario);
            return "funcionarios/editarFuncionario";
        }
    }


    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/funcionarios"; // volta para a lista
    }

    @GetMapping("/detalhes/{id}")
    public String detalhesFuncionario(@PathVariable Long id, Model model) {
        Funcionario funcionario = service.buscarPorId(id).orElse(null);
        model.addAttribute("funcionario", funcionario);
        return "admin/detalhesFuncionario";
    }
}
