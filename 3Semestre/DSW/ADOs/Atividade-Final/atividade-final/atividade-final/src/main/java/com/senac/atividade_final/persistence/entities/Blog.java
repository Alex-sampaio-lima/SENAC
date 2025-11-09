package com.senac.atividade_final.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id") // utilizando apenas para não precisar criar o hashCode e equals manualmente

@Entity
@Table(name = "tb_blog")
public class Blog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotBlank(message = "O Titúlo não pode estar vazio !")
    private String titulo;

    @Column(nullable = false)
    @NotBlank(message = "O autor é obrigatório !")
    private String autor;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = "A data de publicação é obrigatória !")
    @Column(nullable = false)
    private Date dataPublicacao;

    @NotBlank(message = "O texto do blog não pode estar vazio !")
    @Column(nullable = false)
    @Size(min = 10, message = "O texto deve ter no minimo 10 caracteres !")
    private String texto;
};
