package dev.sid.VeritasBackend.Entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import dev.sid.VeritasBackend.shared.PayrollStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "payroll_transactions")
@Data
public class PayrollTransactions {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private Long employeeId;

  @Column(nullable = false)
  private LocalDate payPeriod;

  @Column(nullable = false)
  private BigDecimal grossSalary;

  @Column(nullable = false)
  private BigDecimal grossPay;

  @Column(nullable = false)
  private BigDecimal netPay;

  @Column(nullable = false)
  private BigDecimal taxes;

  @Column(nullable = false)
  private LocalDateTime processedAt;

  @Column(nullable = false)
  private PayrollStatus status;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

}
