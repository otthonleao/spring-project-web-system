package dev.otthon.sistemaweb.web.auth.dtos;

import dev.otthon.sistemaweb.core.validators.Comparison;
import dev.otthon.sistemaweb.core.validators.FieldsComparison;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* Para comparar os campos, podemos utilizar a validação que foi desenvolvida no FieldsComparisonValidator.class
* */

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldsComparison(
        field = "newPassword",
        fieldToCompare = "newPasswordConfirmation",
        fieldError = "newPasswordConfirmation",
        message = "As senhas não conferem",
        comparison = Comparison.EQUAL_TO
)
public class UpdatePasswordForm {

    @NotEmpty
    private String currentPassword;

    @NotEmpty
    private String newPassword;

    @NotEmpty
    private String newPasswordConfirmation;

}
