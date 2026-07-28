package dev.sid.VeritasBackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sid.VeritasBackend.Entities.EmployeeSalaryComponents;

public interface EmployeeSalaryComponentRepository extends JpaRepository<EmployeeSalaryComponents, Long> {
}
