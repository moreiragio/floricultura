package com.floricultura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import com.floricultura.model.Flor;
import com.floricultura.model.Categoria;
import com.floricultura.repository.FlorRepository;
import com.floricultura.repository.CategoriaRepository;
import com.floricultura.model.Usuario;

@Controller
public class PaginaInicialController {

    private final FlorRepository florRepository;
    private final CategoriaRepository categoriaRepository;

    public PaginaInicialController(FlorRepository florRepository, CategoriaRepository categoriaRepository) {
        this.florRepository = florRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Flor> flores = florRepository.findAll();
        List<Categoria> categorias = categoriaRepository.findAll();

        model.addAttribute("flores", flores);
        model.addAttribute("categorias", categorias);

        // Aqui você pode adicionar o usuário logado, se quiser
        // model.addAttribute("usuario", usuarioLogado);

        return "index"; // busca "index.html" no templates
    }
}
