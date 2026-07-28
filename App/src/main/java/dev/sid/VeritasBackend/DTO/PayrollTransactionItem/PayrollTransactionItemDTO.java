package dev.sid.VeritasBackend.DTO.PayrollTransactionItem;

import java.math.BigDecimal;

import dev.sid.VeritasBackend.shared.ComponentTypes;

public record PayrollTransactionItemDTO(
    Long payrollTransactionId,
    String componentName,
    ComponentTypes componentType,
    BigDecimal calculatedAmount) {
}
