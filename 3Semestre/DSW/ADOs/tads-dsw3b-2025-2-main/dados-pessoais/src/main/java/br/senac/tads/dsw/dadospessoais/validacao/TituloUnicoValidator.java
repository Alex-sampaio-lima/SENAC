package br.senac.tads.dsw.dadospessoais.validacao;

import org.springframework.beans.factory.annotation.Autowired;

// import br.senac.tads.dsw.dadospessoais.PessoaService;
import br.senac.tads.dsw.dadospessoais.TarefaService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TituloUnicoValidator implements ConstraintValidator<TituloUnico, String> {

    @Autowired
	private TarefaService tarefaService;

	@Override
	public boolean isValid(String titulo, ConstraintValidatorContext context) {
		return tarefaService.findByTitulo(titulo) == null;
	}

}
