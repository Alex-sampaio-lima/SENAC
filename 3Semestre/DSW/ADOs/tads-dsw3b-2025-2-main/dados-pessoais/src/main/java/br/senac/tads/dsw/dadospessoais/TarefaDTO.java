package br.senac.tads.dsw.dadospessoais;

import java.time.LocalDate;

import br.senac.tads.dsw.dadospessoais.validacao.TituloUnico;
// import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class TarefaDTO {
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

    public TarefaDTO(String titulo, String responsavel, LocalDate dataTermino, String detalhamento) {
        this.titulo = titulo;
        this.responsavel = responsavel;
        this.dataTermino = dataTermino;
        this.detalhamento = detalhamento;
    }


    // public LocalDate getDataTermino() {
    //     return dataTermino;
    // }
    
}
