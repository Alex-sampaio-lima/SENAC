package br.senac.tads.dsw.dadospessoais.validacao;

import org.springframework.beans.factory.annotation.Autowired;

import br.senac.tads.dsw.dadospessoais.BlogService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TituloUnicoValidator implements ConstraintValidator<TituloUnico, String> {

	@Autowired
	private BlogService blogService;

	@Override
	public boolean isValid(String titulo, ConstraintValidatorContext context) {
		return blogService.findByTitulo(titulo) == null;
	}

}
