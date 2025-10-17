package com.floricultura.service;

import com.floricultura.model.Flor;

import java.util.List;
import java.util.Optional;

public interface FlorService {
    List<Flor> listarTodos();
    Optional<Flor> buscarPorId(Long id);
    void salvar(Flor flor);
    void deletar(Long id);
}
