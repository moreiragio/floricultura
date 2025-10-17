package com.floricultura.controller;

import com.floricultura.model.OutroProduto;
import com.floricultura.service.OutroProdutoService;
import com.floricultura.service.FuncionarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/outro_produto")
public class OutroProdutoController {

    private final OutroProdutoService service;
    private final FuncionarioService funcionarioService;

    public OutroProdutoController(OutroProdutoService service, FuncionarioService funcionarioService) {
        this.service = service;
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("outroProduto", new OutroProduto());
        model.addAttribute("funcionarios", funcionarioService.listarTodos());
        return "outro_produto/formOutroProduto";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute OutroProduto outroProduto) {
        service.salvar(outroProduto);
        return "redirect:/outro_produto";
    }
}
