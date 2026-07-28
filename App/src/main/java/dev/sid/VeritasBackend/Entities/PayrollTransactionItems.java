package dev.sid.VeritasBackend.Entities;

import java.math.BigDecimal;
import java.util.UUID;

import dev.sid.VeritasBackend.shared.ComponentTypes;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class PayrollTransactionItems {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @JoinColumn(name = "payroll_transaction_id", nullable = false)
  private PayrollTransactions payrollTransaction;

  @Column(nullable = false)
  private String componentName;

  @Column(nullable = false)
  private ComponentTypes componentType;

  @Column(nullable = false)
  private BigDecimal calculatedAmount;
}
