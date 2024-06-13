package dev.otthon.sistemaweb.web.employees.mappers;

import dev.otthon.sistemaweb.core.exceptions.PositionNotFoundException;
import dev.otthon.sistemaweb.core.models.Employee;
import dev.otthon.sistemaweb.core.repositories.EmployeeRepository;
import dev.otthon.sistemaweb.core.repositories.PositionRepository;
import dev.otthon.sistemaweb.core.utils.StringUtils;
import dev.otthon.sistemaweb.web.employees.dtos.EmployeeDetails;
import dev.otthon.sistemaweb.web.employees.dtos.EmployeeForm;
import dev.otthon.sistemaweb.web.employees.dtos.EmployeeListItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeMapperImpl implements EmployeeMapper {

    private final AddressMapper addressMapper;
    private final PositionRepository positionRepository;

    @Override
    public Employee toEmployee(EmployeeForm employeeForm) {

        var position = positionRepository.findById(employeeForm.getPositionId())
                .orElseThrow(PositionNotFoundException::new);

        return Employee.builder()
                .name(employeeForm.getName())
                .email(employeeForm.getEmail())
                .phone(StringUtils.cleanPhone(employeeForm.getPhone()))
                .cpf(StringUtils.cleanCpf(employeeForm.getCpf()))
                .birthDate(employeeForm.getBirthDate())
                .hireDate(employeeForm.getHireDate())
                .resignationDate(employeeForm.getResignationDate())
                .address(addressMapper.toAddress(employeeForm.getAddress()))
                .position(position)
                .build();
    }

    @Override
    public EmployeeForm toEmployeeForm(Employee employee) {
        return EmployeeForm.builder()
                .name(employee.getName())
                .email(employee.getEmail())
                .phone(StringUtils.formatPhone(employee.getPhone()))
                .cpf(StringUtils.formatCpf(employee.getCpf()))
                .birthDate(employee.getBirthDate())
                .hireDate(employee.getHireDate())
                .resignationDate(employee.getResignationDate())
                .address(addressMapper.toAddressForm(employee.getAddress()))
                .positionId(employee.getPosition().getId())
                .build();
    }

    @Override
    public EmployeeListItem toEmployeeListItem(Employee employee) {
        return EmployeeListItem.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .phone(StringUtils.formatPhone(employee.getPhone()))
                .position(employee.getPosition().getName())
                .build();
    }

    @Override
    public EmployeeDetails toEmployeeDetails(Employee employee) {
        return EmployeeDetails.builder()
                .name(employee.getName())
                .email(employee.getEmail())
                .phone(StringUtils.formatPhone(employee.getPhone()))
                .cpf(StringUtils.formatCpf(employee.getCpf()))
                .birthDate(employee.getBirthDate())
                .hireDate(employee.getHireDate())
                .resignationDate(employee.getResignationDate())
                .address(addressMapper.formatAddress(employee.getAddress()))
                .position(employee.getPosition().getName())
                .build();
    }

}
