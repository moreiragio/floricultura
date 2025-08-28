package com.floricultura.repository;

import com.floricultura.model.Flor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlorRepository extends JpaRepository<Flor, Long> { }