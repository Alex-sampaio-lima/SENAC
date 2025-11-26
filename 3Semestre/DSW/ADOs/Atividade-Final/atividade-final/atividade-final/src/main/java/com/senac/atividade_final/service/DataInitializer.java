package com.senac.atividade_final.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.senac.atividade_final.persistence.entities.Blog;
import com.senac.atividade_final.persistence.repository.BlogRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {
    @Autowired
    private BlogRepository blogRepository;

    @PostConstruct
    public void init() {
        if (blogRepository.count() == 0) {
            criarDadosIniciais();
        }
        ;
    };

    private void criarDadosIniciais() {
        try {
            Blog blog = new Blog();
            blog.setTitulo("20 Dicas para falar bem");
            blog.setAutor("Alexsander Sampaio Lima");
            blog.setDataPublicacao(LocalDate.now());
            blog.setTexto("Aqui estão 20 dicas para você falar melhor em público.");

            blogRepository.save(blog);

            System.out.println("Dados iniciais criados com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao criar dados iniciais: " + e.getMessage());
        }
    };
};
