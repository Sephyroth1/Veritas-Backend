package dev.sid.VeritasBackend.DTO.SalaryComponent;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public record SalaryComponentDTO(
        @NotNull Long id,
        @NotNull BigDecimal basicSalary,
        @NotNull BigDecimal hra,
        @NotNull BigDecimal da,
        @NotNull BigDecimal specialAllowance,
        @NotNull BigDecimal deductions) {
}
