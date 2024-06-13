package dev.otthon.sistemaweb.core.repositories;

import dev.otthon.sistemaweb.core.models.Project;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @EntityGraph(attributePaths = { "client", "manager" })
    List<Project> findAll();

    @EntityGraph(attributePaths = { "client", "manager", "team", "team.position" })

    Optional<Project> findById(Long id);

}
