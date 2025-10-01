package br.senac.tads.dsw.dadospessoais;

import java.time.LocalDate;

import br.senac.tads.dsw.dadospessoais.validacao.TituloUnico;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BlogDTO {
    @NotBlank(message = "O título não pode estar vazio")
    @TituloUnico
    private String titulo;

    @NotBlank(message = "O Autor precisa ser preenchido")
    private String autor;

    @NotNull(message = "A data de publicação é obrigatória")
    @FutureOrPresent
    private LocalDate dataPublicacao;

    @Size(min = 10, max = 255)
    private String texto;

    public BlogDTO(String titulo, String autor, LocalDate dataPublicacao, String texto) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.texto = texto;
    }

}
