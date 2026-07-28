package dev.sid.VeritasBackend.DTO.EmployeeSalaryComponent;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import dev.sid.VeritasBackend.shared.CalculateTypes;

public record CreateEmployeeSalaryComponentDTO(
  UUID employeeId,
  Long componentTypeId,
  BigDecimal value,
  CalculateTypes calculateType,
  LocalDate effectiveFrom,
  LocalDate effectiveTo
) {
}
