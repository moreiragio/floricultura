package com.floricultura.service;

import com.floricultura.model.Flor;
import com.floricultura.repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlorService {
    @Autowired
    private FlorRepository florRepository;

    public Flor save(Flor f) { return florRepository.save(f); }
    public Flor get(Long id) { return florRepository.findById(id).orElse(null); }
    public List<Flor> list() { return florRepository.findAll(); }
    public void delete(Long id) { florRepository.deleteById(id); }
}