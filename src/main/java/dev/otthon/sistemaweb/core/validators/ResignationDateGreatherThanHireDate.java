package dev.otthon.sistemaweb.core.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* VALIDA A CLASSE E ASSIM É POSSÍVEL VALIDAR DOIS CAMPOS
* Nesse caso, irá comparar como exemplo as datas que tenham o mesmo tipo
* Assim, podemos validar que a data de demissão não pode ser anterior que a data de contratação
* */

@Target(ElementType.TYPE) // Define que a annotation é para uma classe
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ResignationDateGreatherThanHireDateValidator.class)
public @interface ResignationDateGreatherThanHireDate {

    String message() default "a data de demissão deve ser posterior a data de contratação";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
