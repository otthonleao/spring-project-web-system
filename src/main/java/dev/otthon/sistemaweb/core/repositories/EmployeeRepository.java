package dev.otthon.sistemaweb.core.repositories;

import dev.otthon.sistemaweb.core.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
