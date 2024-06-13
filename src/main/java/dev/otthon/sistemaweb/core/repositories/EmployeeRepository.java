package dev.otthon.sistemaweb.core.repositories;

import dev.otthon.sistemaweb.core.models.Employee;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @EntityGraph(attributePaths = "position")
    List<Employee> findAll();

    @EntityGraph(attributePaths = { "position", "address", "projects" })
    Optional<Employee> findById(Long id);

    List<Employee> findByPositionName(String positionName);

    List<Employee> findByPositionNameNot(String positionName);

    @Query("SELECT e FROM Employee e WHERE e.position.name = 'Gerente de projetos'")
    List<Employee> findManagers();
}
