package dev.sid.VeritasBackend.DTO.PayrollTransaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PayrollTransactionDTO(
    UUID employeeId,
    String payPeriod,
    BigDecimal grossSalary,
    BigDecimal netSalary,
    BigDecimal totalDeductions,
    String processedBy,
    LocalDateTime processedAt,
    String status) {
}
