package dev.sid.VeritasBackend.DTO.Employee;

import java.math.BigDecimal;
import java.util.List;

import dev.sid.VeritasBackend.DTO.EmployeeSalaryComponent.EmployeeSalaryComponentResponseDTO;

public record SalaryOverviewDTO(
    BigDecimal totalSalary,
    BigDecimal netSalary,
    BigDecimal grossSalary,
    List<EmployeeSalaryComponentResponseDTO> salaryComponents) {
}
