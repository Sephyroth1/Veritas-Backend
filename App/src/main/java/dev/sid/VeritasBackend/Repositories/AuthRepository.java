package dev.sid.VeritasBackend.Repositories;

import java.util.UUID;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.sid.VeritasBackend.Entities.Users;

@Repository
public interface AuthRepository extends JpaRepository<Users, UUID> {
    Optional<Users> findByUsername(String username);
}
