package com.floricultura.controller;

import com.floricultura.model.Flor;
import com.floricultura.service.FlorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/flores")
public class FlorController {

    private final FlorService florService;

    public FlorController(FlorService florService) {
        this.florService = florService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("flores", florService.listarTodas());
        return "flor-list";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("flor", new Flor());
        return "flor-form";
    }

    @PostMapping("/salvar")
    public String salvar(Flor flor) {
        florService.salvar(flor);
        return "redirect:/flores";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("flor", florService.buscarPorId(id));
        return "flor-form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        florService.excluir(id);
        return "redirect:/flores";
    }
}
