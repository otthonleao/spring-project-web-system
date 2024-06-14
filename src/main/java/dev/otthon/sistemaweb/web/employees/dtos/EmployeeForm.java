package dev.otthon.sistemaweb.web.employees.dtos;

import dev.otthon.sistemaweb.core.validators.Age;
import dev.otthon.sistemaweb.core.validators.Comparison;
import dev.otthon.sistemaweb.core.validators.FieldsComparison;
import dev.otthon.sistemaweb.core.validators.ResignationDateGreatherThanHireDate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@ResignationDateGreatherThanHireDate
@FieldsComparison(
        field = "hireDate",
        fieldToCompare = "resignationDate",
        comparison = Comparison.LESS_THAN,
        message = "a data de demissão deve ser maior que a data de contratação",
        fieldError = "resignationDate"
)
public class EmployeeForm {

    @NotEmpty
    @Size(min = 3, max = 100)
    private String name;

    @Email
    @NotEmpty
    @Size(max = 255)
    private String email;

    @NotEmpty
    @Size(min = 15, max = 15)
    @Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}$", message = "deve estar no formato (00) 00000-0000")
    private String phone;

    @CPF
    @NotEmpty
    @Size(min = 14, max = 14)
    private String cpf;

    @Past
    @NotNull
    @Age(min = 18, max = 100)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;

    @NotNull
    @PastOrPresent
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate hireDate;

    @PastOrPresent
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate resignationDate;

    @Valid
    private AddressForm address;

    @NotNull
    @Positive
    private Long positionId;

}
