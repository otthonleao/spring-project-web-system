package dev.otthon.sistemaweb.core.repositories;

import dev.otthon.sistemaweb.core.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
