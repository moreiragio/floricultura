package com.floricultura.repository;

import com.floricultura.model.Flor;
import java.util.List;
import java.util.ArrayList;

public class FlorRepository {

    public List<Flor> findAll() {
        List<Flor> flores = new ArrayList<>();
        flores.add(new Flor("Rosa", "Rosa vermelha", "Vermelho", 10.0));
        flores.add(new Flor("Tulipa", "Tulipa amarela", "Amarelo", 8.0));
        flores.add(new Flor("Margarida", "Margarida branca", "Branco", 6.5));
        return flores;
    }
}
