package dev.sid.VeritasBackend.DTO.Employee;

import java.util.UUID;

public record EmployeeSummaryDTO(
        UUID id,
        Long employeeCode,
        String name,
        String email,
        String department,
        String designation,
        String employmentType) {

}
