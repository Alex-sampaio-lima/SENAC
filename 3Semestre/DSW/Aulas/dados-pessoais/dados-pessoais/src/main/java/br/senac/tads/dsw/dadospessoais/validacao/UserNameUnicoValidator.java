package br.senac.tads.dsw.dadospessoais.validacao;

import org.springframework.beans.factory.annotation.Autowired;

import br.senac.tads.dsw.dadospessoais.Pessoa;
import br.senac.tads.dsw.dadospessoais.PessoaService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserNameUnicoValidator implements ConstraintValidator<UserNameUnico, Pessoa> {

    @Autowired
    private PessoaService service;

    @Override
    public boolean isValid(Pessoa pessoa, ConstraintValidatorContext context) {
        return (service.findByUsername(pessoa.getUsername()) == null);
    }
};
