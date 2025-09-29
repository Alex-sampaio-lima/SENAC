package br.senac.tads.dsw.dadospessoais.validacao;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.FIELD})
@Constraint(validatedBy = UserNameUnicoValidator.class)
@Retention(RetentionPolicy.RUNTIME)

public @interface UserNameUnico {

    String message() default "Username já cadastrado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
