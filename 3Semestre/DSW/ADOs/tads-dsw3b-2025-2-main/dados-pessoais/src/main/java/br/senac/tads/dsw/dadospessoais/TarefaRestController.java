package br.senac.tads.dsw.dadospessoais;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.senac.tads.dsw.dadospessoais.TarefaService;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins = "*")
public class TarefaRestController {

    @Autowired
    private TarefaService service;

    @GetMapping
    public List<TarefaDTO> findAll() {
        return service.findAll();
    }
    
    @GetMapping("/{titulo}")
    public TarefaDTO findByTituloRequestParam(
            @PathVariable(value = "titulo") String u) {
        return service.findByTitulo(u);
    }

    // @GetMapping("/{titulo}")    
    // public TarefaDTO findByUsername(@PathVariable("username") String username) {
    //     TarefaDTO tarefa = service.findByTitulo(username);
    //     if (tarefa == null) {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND,
    //             "Tarefa %s não encontrada".formatted(username));
    //     }
    //     return tarefa;
    // }

    @PostMapping
    public ResponseEntity<TarefaDTO> addNew(@RequestBody @Valid TarefaDTO input) {
        TarefaDTO tarefa = service.addNew(input);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequestUri()
            .path("/{titulo}")
            .buildAndExpand(tarefa.getTitulo())
            .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{titulo}")
    public ResponseEntity<TarefaDTO> update(@PathVariable String username, 
            @RequestBody @Valid TarefaDTO input) {
            TarefaDTO pessoa = service.findByTitulo(username);
        if (pessoa == null) {
            return ResponseEntity.notFound().build();
        }
        service.update(username, input);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> delete(@PathVariable String titulo) {
        service.delete(titulo);
        return ResponseEntity.noContent().build();
    }

    // // Handle @Valid validation errors
    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
    //     Map<String, String> errors = new HashMap<>();
    //     for (FieldError error : ex.getBindingResult().getFieldErrors()) {
    //         errors.put(error.getField(), error.getDefaultMessage());
    //     }
    //     return ResponseEntity.badRequest().body(errors);
    // }

}
 