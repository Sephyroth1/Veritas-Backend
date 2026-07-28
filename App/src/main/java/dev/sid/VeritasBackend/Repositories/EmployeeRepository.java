package dev.sid.VeritasBackend.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sid.VeritasBackend.Entities.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, UUID> {
}
