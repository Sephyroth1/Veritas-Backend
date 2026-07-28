package dev.sid.VeritasBackend.Entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "salary_components")
@Data
public class SalaryComponents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "basic_salary", precision = 12, scale = 2, nullable = false)
    private BigDecimal basicSalary;

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal hra;

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal da;

    @Column(name = "special_allowances", precision = 12, scale = 2, nullable = false)
    private BigDecimal specialAllowances;

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal deductions;

    @Column(name = "effective_from", nullable = false)
    private LocalDateTime effectiveFrom;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
