package com.floricultura.controller;

import com.floricultura.model.Flor;
import com.floricultura.service.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flores")
public class FlorController {
    @Autowired
    private FlorService florService;

    @GetMapping
    public List<Flor> listar() { return florService.list(); }

    @PreAuthorize("hasRole('FUNCIONARIO')")
    @PostMapping
    public Flor criar(@RequestBody Flor f) { return florService.save(f); }

    @PreAuthorize("hasRole('FUNCIONARIO')")
    @PutMapping("/{id}")
    public Flor atualizar(@PathVariable Long id, @RequestBody Flor f) {
        f.setId(id);
        return florService.save(f);
    }

    @PreAuthorize("hasRole('FUNCIONARIO')")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) { florService.delete(id); }
}