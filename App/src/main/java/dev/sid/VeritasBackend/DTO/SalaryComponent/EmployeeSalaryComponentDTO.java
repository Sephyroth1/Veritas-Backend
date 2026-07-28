package dev.sid.VeritasBackend.DTO.SalaryComponent;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import dev.sid.VeritasBackend.shared.CalculateTypes;
import jakarta.validation.constraints.NotNull;

public record EmployeeSalaryComponentDTO(
    @NotNull UUID employeeId,
    @NotNull Long ComponentTypeId,
    @NotNull BigDecimal value,
    @NotNull CalculateTypes calculateType,
    @NotNull LocalDate effectiveFrom,
    @NotNull LocalDate effectiveTo) {
}
