package com.floricultura.service.serviceImpl;

import com.floricultura.model.Flor;
import com.floricultura.repository.FlorRepository;
import com.floricultura.service.FlorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlorServiceImpl implements FlorService {

    private final FlorRepository repository;

    public FlorServiceImpl(FlorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Flor> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Flor> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public void salvar(Flor flor) {
        repository.save(flor);
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
