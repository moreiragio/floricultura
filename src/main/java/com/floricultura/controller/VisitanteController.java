package com.floricultura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisitanteController {

    @GetMapping("/visitante/inicio")
    public String inicioVisitante() {
        return "inicio";
    }
}
