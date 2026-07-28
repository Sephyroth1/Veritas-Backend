package dev.sid.VeritasBackend.Entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import dev.sid.VeritasBackend.shared.CalculateTypes;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class EmployeeSalaryComponents {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private UUID employeeId;

  @Column(nullable = false)
  private Long componentTypeId;

  @Column(nullable = false)
  private BigDecimal value;

  @Column(nullable = false)
  private CalculateTypes calculateType;

  @Column(nullable = false)
  private LocalDate effectiveFrom;

  @Column(nullable = false)
  private LocalDate effectiveTo;
}
