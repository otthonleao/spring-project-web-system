package dev.otthon.sistemaweb.core.validators;

import dev.otthon.sistemaweb.web.employees.dtos.EmployeeForm;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ResignationDateGreatherThanHireDateValidator implements ConstraintValidator<ResignationDateGreatherThanHireDate, EmployeeForm> {

    private String message;

    @Override
    public boolean isValid(EmployeeForm employeeFormValue, ConstraintValidatorContext constraintValidatorContext) {
        if (employeeFormValue == null) {
            return true;
        }

        if (employeeFormValue.getHireDate() == null || employeeFormValue.getResignationDate() == null) {
            return true;
        }

        // Mudando o comportamento padrão que está exibindo o erro de forma 'global'
        // para ser exibido no campo 'Data de Demissão'
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                .addPropertyNode("resignationDate")
                .addConstraintViolation();

        return employeeFormValue.getResignationDate().isAfter(employeeFormValue.getHireDate());
    }

    @Override
    public void initialize(ResignationDateGreatherThanHireDate constraintAnnotation) {
        message = constraintAnnotation.message();
    }
}
