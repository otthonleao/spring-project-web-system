package dev.otthon.sistemaweb.core.repositories;

import dev.otthon.sistemaweb.core.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
