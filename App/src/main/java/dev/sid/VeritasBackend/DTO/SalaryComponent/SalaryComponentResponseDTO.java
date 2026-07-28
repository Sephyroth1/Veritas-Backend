package dev.sid.VeritasBackend.DTO.SalaryComponent;

import java.math.BigDecimal;

public record SalaryComponentResponseDTO(
        Long id,
        Long employeeId,
        BigDecimal basicSalary,
        BigDecimal hra,
        BigDecimal da,
        BigDecimal specialAllowance,
        BigDecimal deductions,
        BigDecimal grossSalary,
        BigDecimal netSalary) {
}
