package dev.otthon.sistemaweb.web.employees.mappers;

import dev.otthon.sistemaweb.core.models.Employee;
import dev.otthon.sistemaweb.web.employees.dtos.EmployeeDetails;
import dev.otthon.sistemaweb.web.employees.dtos.EmployeeForm;
import dev.otthon.sistemaweb.web.employees.dtos.EmployeeListItem;

public interface EmployeeMapper {

    Employee toEmployee(EmployeeForm employeeForm);

    EmployeeForm toEmployeeForm(Employee employee);

    EmployeeListItem toEmployeeListItem(Employee employee);

    EmployeeDetails toEmployeeDetails(Employee employee);
}
