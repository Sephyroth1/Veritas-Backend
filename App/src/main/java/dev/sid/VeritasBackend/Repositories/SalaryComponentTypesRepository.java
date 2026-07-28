package dev.sid.VeritasBackend.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sid.VeritasBackend.Entities.SalaryComponentTypes;

public interface SalaryComponentTypesRepository extends JpaRepository<SalaryComponentTypes, Long> {
  Optional<SalaryComponentTypes> findById(Long id);
}
