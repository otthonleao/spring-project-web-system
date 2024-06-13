package dev.otthon.sistemaweb.core.repositories;

import dev.otthon.sistemaweb.core.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
