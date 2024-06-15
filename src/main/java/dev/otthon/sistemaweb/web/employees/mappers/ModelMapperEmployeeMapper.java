package dev.otthon.sistemaweb.web.employees.mappers;

import dev.otthon.sistemaweb.core.models.Employee;
import dev.otthon.sistemaweb.web.employees.dtos.EmployeeDetails;
import dev.otthon.sistemaweb.web.employees.dtos.EmployeeForm;
import dev.otthon.sistemaweb.web.employees.dtos.EmployeeListItem;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(
        name = "dev.otthon.sistemaweb.mappers.provider",
        havingValue = "modelmapper"
)
public class ModelMapperEmployeeMapper implements EmployeeMapper {

    private final ModelMapper modelMapper;

    @Override
    public Employee toEmployee(EmployeeForm employeeForm) {
        return modelMapper.map(employeeForm, Employee.class);
    }

    @Override
    public EmployeeForm toEmployeeForm(Employee employee) {
        return modelMapper.map(employee, EmployeeForm.class);
    }

    @Override
    public EmployeeListItem toEmployeeListItem(Employee employee) {
        return modelMapper.map(employee, EmployeeListItem.class);
    }

    @Override
    public EmployeeDetails toEmployeeDetails(Employee employee) {
        return modelMapper.map(employee, EmployeeDetails.class);
    }
}
