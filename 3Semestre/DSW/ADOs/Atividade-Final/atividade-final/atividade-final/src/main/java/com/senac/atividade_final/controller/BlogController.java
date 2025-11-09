package com.senac.atividade_final.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.atividade_final.persistence.entities.Blog;
import com.senac.atividade_final.service.BlogService;

@RestController // Ela combina a anotação @Controller com @ResponseBody
@RequestMapping("/blog")
public class BlogController {

    // o @AutoWired indica que o atributo/dependência abaixo precisa ser injetado,
    // automaticamente injetada na minha classe
    @Autowired
    private BlogService blogService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Blog> getId(@PathVariable int id) {
        return ResponseEntity.ok().body(blogService.getById(id));
    };

    @GetMapping
    public ResponseEntity<List<Blog>> getAll() {
        return ResponseEntity.ok().body(blogService.getAll());
    };

    @PostMapping("postar")
    public ResponseEntity<Blog> newPost(@RequestBody Blog novoBlog) {
        return ResponseEntity.status(HttpStatus.CREATED).body(blogService.create(novoBlog));
    };

    @PutMapping(value = "/{id}")
    public ResponseEntity<Blog> update(@PathVariable int id, @RequestBody Blog novoBlog) {
        novoBlog.setId(id);
        return ResponseEntity.ok().body(blogService.update(novoBlog));
    };

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        blogService.delete(id);
        return ResponseEntity.noContent().build();
    };

};
