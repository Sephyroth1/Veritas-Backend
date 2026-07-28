package dev.sid.VeritasBackend.DTO.Employee;

import java.time.LocalDate;
import java.util.UUID;

import dev.sid.VeritasBackend.DTO.SalaryComponent.SalaryComponentDTO;

public record EmployeeDetailsDTO(
        UUID id,
        Long employeeCode,
        String name,
        String email,
        String department,
        String designation,
        String employmentType,
        LocalDate dateOfJoining,
        SalaryComponentDTO salaryComponents,
        LocalDate createdAt,
        LocalDate updatedAt) {

}
