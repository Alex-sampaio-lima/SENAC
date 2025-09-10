package br.senac.tads.dsw.dados_pessoais;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaService {

    private Map<String, Pessoa> mapPessoa;

    public PessoaService() {
        mapPessoa = new HashMap<>();
        mapPessoa.put("fulano", new Pessoa("Fulano", "Fulano da Silva Sauro", LocalDate.parse("2000-10-20"), "fulano@email.com", "11 940264105", "senhaDoFulano", List.of("Java", "Spring Boot")));

        mapPessoa.put("Beltrano", new Pessoa("Beltrano", "Beltrano da Silva Sauro", LocalDate.parse("2000-10-20"), "Beltrano@email.com", "11 940264105", "senhaDoBeltrano", List.of("Java", "Spring Boot", "Mamada Invertida")));

        mapPessoa.put("Ciclano", new Pessoa("Ciclano", "Ciclano da Silva Sauro", LocalDate.parse("2000-10-20"), "Ciclano@email.com", "11 940264105", "senhaDoCiclano", List.of("Java", "CSS", "Spring Boot")));
    }

    @GetMapping
    public List<Pessoa> findAll() {

        List<Pessoa> pessoas = new ArrayList<>(mapPessoa.values());
        // List<Pessoa> pessoas = (List<Pessoa>) mapPessoa.value();
        return pessoas;
    }

    public Pessoa findByUsername(String username) {
        return new Pessoa("Fulano", "Fulano da Silva Sauro", LocalDate.parse("2000-10-20"), "fulano@email.com", "11 940264105", "senhaDoFulano", List.of("Java", "Spring Boot"));
    }

    public Pessoa addNew(Pessoa pessoa) {
        return null;
    }

    public Pessoa update(String username, Pessoa pessoa) {
        return null;

    }

};
