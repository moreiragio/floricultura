package com.floricultura.service;

import com.floricultura.model.Flor;
import com.floricultura.repository.FlorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlorService {

    private final FlorRepository florRepository;

    public FlorService(FlorRepository florRepository) {
        this.florRepository = florRepository;
    }

    public List<Flor> listarTodas() {
        return florRepository.findAll();
    }

    public Flor salvar(Flor flor) {
        return florRepository.save(flor);
    }

    public Flor buscarPorId(Long id) {
        return florRepository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        florRepository.deleteById(id);
    }
}
