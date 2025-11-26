package com.senac.atividade_final.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.atividade_final.persistence.entities.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    boolean existsByTitulo(String titulo);
};
