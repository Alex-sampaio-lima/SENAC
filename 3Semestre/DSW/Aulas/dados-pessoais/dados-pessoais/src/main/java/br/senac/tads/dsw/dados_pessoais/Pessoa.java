package br.senac.tads.dsw.dados_pessoais;

import java.time.LocalDate;
import java.util.List;

// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// Uma forma diferente de usar Getters, Setters e Constructors 
public class Pessoa { // POJO

    private String username;
    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;
    private String senha;
    private List<String> interesse;
    // private String[] interesse;

    public Pessoa(String username, String nome, LocalDate dataNascimento, String email, String telefone, String senha,
            List<String> interesse) {
        this.username = username;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.interesse = interesse;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<String> getInteresse() {
        return interesse;
    }

    public void setInteresse(List<String> interesse) {
        this.interesse = interesse;
    }

};
