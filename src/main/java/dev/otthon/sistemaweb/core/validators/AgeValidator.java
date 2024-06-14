package dev.otthon.sistemaweb.core.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class AgeValidator implements ConstraintValidator<Age, LocalDate> {

    private int min;
    private int max;

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        if (localDate == null) {
            return true;
        }

        var today = LocalDate.now();
        var age = today.getYear() - localDate.getYear();

        // Verificando se já fez aniversário
        if (localDate.getDayOfYear() < today.getDayOfYear()) {
            age--;
        }

        return age >= min && age <= max;
    }

    @Override
    public void initialize(Age constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
        validateParams();
    }

    private void validateParams() {
        if (min < 0) {
            throw new IllegalArgumentException("O valor mínimo não pode ser negativo");
        }

        if (max < 0) {
            throw new IllegalArgumentException("O valor máximo não pode ser negativo");
        }

        if (max < min) {
            throw new IllegalArgumentException("O valor máximo não pode ser menor que o valor mínimo");
        }
    }

}
