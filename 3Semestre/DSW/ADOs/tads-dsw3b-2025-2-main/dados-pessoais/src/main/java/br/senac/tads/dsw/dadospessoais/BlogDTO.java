package br.senac.tads.dsw.dadospessoais;

import java.time.LocalDate;

import br.senac.tads.dsw.dadospessoais.validacao.TituloUnico;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BlogDTO {
    @NotBlank(message = "O título não pode estar vazio")
    @TituloUnico
    private String titulo;

    @NotBlank(message = "O Responsável não pode estar vazio")
    // @Size(min = 1, max = 100)
    private String responsavel;

    @NotNull(message = "A data de término é obrigatória")
    @FutureOrPresent
    private LocalDate dataTermino;

    private String detalhamento;

    public BlogDTO(String titulo, String responsavel, LocalDate dataTermino, String detalhamento) {
        this.titulo = titulo;
        this.responsavel = responsavel;
        this.dataTermino = dataTermino;
        this.detalhamento = detalhamento;
    }

    // public LocalDate getDataTermino() {
    // return dataTermino;
    // }

}
