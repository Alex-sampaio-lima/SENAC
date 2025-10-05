package br.senac.tads.dsw.dadospessoais;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/blog")
@CrossOrigin(origins = "*")
public class BlogRestController {

    @Autowired
    private BlogService service;

    @GetMapping
    public List<BlogDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{titulo}")
    public BlogDTO findByTituloRequestParam(
            @PathVariable(value = "titulo") String u) {
        return service.findByTitulo(u);
    }

    @PostMapping
    public ResponseEntity<BlogDTO> addNew(@RequestBody @Valid BlogDTO input) {
        BlogDTO blog = service.addNew(input);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{titulo}")
                .buildAndExpand(blog.getTitulo())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    // @PutMapping("/{titulo}")
    // public ResponseEntity<BlogDTO> update(@PathVariable String username,
    // @RequestBody @Valid BlogDTO input) {
    // BlogDTO pessoa = service.findByTitulo(username);
    // if (pessoa == null) {
    // return ResponseEntity.notFound().build();
    // }
    // service.update(username, input);
    // return ResponseEntity.noContent().build();
    // }

    // @DeleteMapping("/{username}")
    // public ResponseEntity<Void> delete(@PathVariable String titulo) {
    // service.delete(titulo);
    // return ResponseEntity.noContent().build();
    // }

}
