package com.senac.atividade_final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.atividade_final.persistence.entities.Blog;
import com.senac.atividade_final.persistence.repository.BlogRepository;

@Service
public class BlogService {
    @Autowired
    private BlogRepository repository;

    public Blog create(Blog blog) {
        return repository.save(blog);
    }

    public void delete(int id) {
        repository.deleteById(id);
    };

    public Blog getById(int id) {
        Optional<Blog> blog = repository.findById(id);
        return blog.get();
    };

    public List<Blog> getAll() {
        return repository.findAll();
    };

    public Blog update(Blog blog) {
        Optional<Blog> novoBlog = repository.findById(blog.getId());
        updateBlog(novoBlog, blog);
        return repository.save(novoBlog.get());
    };

    private void updateBlog(Optional<Blog> novoBlog, Blog blog) {
        novoBlog.get().setTitulo(blog.getTitulo());
        novoBlog.get().setAutor(blog.getAutor());
        novoBlog.get().setDataPublicacao(blog.getDataPublicacao());
        novoBlog.get().setTexto(blog.getTexto());
    };

};
