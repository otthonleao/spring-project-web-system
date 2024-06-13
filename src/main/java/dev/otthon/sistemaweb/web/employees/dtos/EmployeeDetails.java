package dev.otthon.sistemaweb.web.employees.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetails {

    private String name;

    private String email;

    private String phone;

    private String cpf;

    private LocalDate birthDate;

    private LocalDate hireDate;

    private LocalDate resignationDate;

    private String address;

    private String position;

    private List<EmployeeProjectListItem> projects;

}
