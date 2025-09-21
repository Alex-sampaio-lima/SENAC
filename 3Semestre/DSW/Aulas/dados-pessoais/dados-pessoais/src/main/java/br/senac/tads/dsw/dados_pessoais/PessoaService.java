package br.senac.tads.dsw.dados_pessoais;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


@Service
public class PessoaService {

    private Map<String, Pessoa> mapPessoas;

    public PessoaService() {
        mapPessoas = new HashMap<>();
        mapPessoas.put("fulano", new Pessoa("Fulano", "Fulano da Silva Sauro", LocalDate.parse("2000-10-20"), "fulano@email.com", "11 940264105", "senhaDoFulano", List.of("Java", "Spring Boot")));

        mapPessoas.put("Beltrano", new Pessoa("Beltrano", "Beltrano da Silva Sauro", LocalDate.parse("2000-10-20"), "Beltrano@email.com", "11 940264105", "senhaDoBeltrano", List.of("Java", "Spring Boot", "Mamada Invertida")));

        mapPessoas.put("Ciclano", new Pessoa("Ciclano", "Ciclano da Silva Sauro", LocalDate.parse("2000-10-20"), "Ciclano@email.com", "11 940264105", "senhaDoCiclano", List.of("Java", "CSS", "Spring Boot")));
    }

    @GetMapping
    public List<Pessoa> findAll() {

        List<Pessoa> pessoas = new ArrayList<>(mapPessoas.values());
        // List<Pessoa> pessoas = (List<Pessoa>) mapPessoas.value();
        return pessoas;
    }

    public Pessoa findByUsername(String username) {
        // return new Pessoa("Fulano", "Fulano da Silva Sauro", LocalDate.parse("2000-10-20"), "fulano@email.com", "11 940264105", "senhaDoFulano", List.of("Java", "Spring Boot"));
        return mapPessoas.get(username);
    }

    public Pessoa addNew(Pessoa pessoa) {
        mapPessoas.put(pessoa.getUsername(), pessoa);
        return pessoa;
    }

    public Pessoa update(String username, Pessoa pessoa) {
        if (mapPessoas.containsKey(username)) {
            //erro
        }
        mapPessoas.put(username, pessoa);
        return pessoa;
    }

    public void delete(String username) {
        mapPessoas.remove(username);
    }
    
};
