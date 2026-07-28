package dev.sid.VeritasBackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sid.VeritasBackend.Entities.SalaryComponents;

public interface SalaryComponentsRepository extends JpaRepository<SalaryComponents, Long> {

}
