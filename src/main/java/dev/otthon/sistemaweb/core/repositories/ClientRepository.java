package dev.otthon.sistemaweb.core.repositories;

import dev.otthon.sistemaweb.core.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByEmail(String email);

    Optional<Client> findByEmailAndIdNot(String email, Long id);

}
