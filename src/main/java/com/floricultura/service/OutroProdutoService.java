package com.floricultura.service;

import com.floricultura.model.OutroProduto;
import com.floricultura.repository.OutroProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutroProdutoService {

    private final OutroProdutoRepository repository;

    public OutroProdutoService(OutroProdutoRepository repository) {
        this.repository = repository;
    }

    public List<OutroProduto> listarTodos() {
        return repository.findAll();
    }

    public void salvar(OutroProduto outroProduto) {
        repository.save(outroProduto);
    }

    public Optional<OutroProduto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
