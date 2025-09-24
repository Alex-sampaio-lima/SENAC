package br.senac.tads.dsw.dadospessoais.validacao;

import org.springframework.beans.factory.annotation.Autowired;

import br.senac.tads.dsw.dadospessoais.Pessoa;
import br.senac.tads.dsw.dadospessoais.PessoaService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SenhasIguaisValidator implements ConstraintValidator<SenhasIguais, Pessoa> {

    @Override
    public boolean isValid(Pessoa pessoa, ConstraintValidatorContext context) {
        return pessoa.getSenha() != null && pessoa.getSenha().equals(pessoa.getRepeticaoSenha());

    }

}
