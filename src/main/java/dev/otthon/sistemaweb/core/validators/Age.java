package dev.otthon.sistemaweb.core.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // recebe aonde essa anotação vai ser utilizada
@Retention(RetentionPolicy.RUNTIME) // em que momento a validação vai ser processada
@Constraint(validatedBy = AgeValidator.class) // qual a classe que de fato vai ocorrer a lógica de validação dessa anotação
public @interface Age {

    String message() default "A idade deve estar entre {min} e {max}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int min() default 0;

    int max() default Integer.MAX_VALUE;

}
