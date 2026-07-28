package dev.sid.VeritasBackend.DTO.EmployeeSalaryComponent;

import java.math.BigDecimal;
import java.time.LocalDate;

import dev.sid.VeritasBackend.shared.CalculateTypes;

public record EmployeeSalaryComponentResponseDTO(
    Long id,
    Long componentTypeId,
    BigDecimal value,
    CalculateTypes calculateType,
    LocalDate effectiveFrom,
    LocalDate effectiveTo) {
}
