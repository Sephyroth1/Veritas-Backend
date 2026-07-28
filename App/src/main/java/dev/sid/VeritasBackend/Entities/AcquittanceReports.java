// acquittance_reports
// -------------------
// id
// employee_id
// payroll_transaction_id
// report_type
// generated_by
// generated_at
// file_path

package dev.sid.VeritasBackend.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.Id;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class AcquittanceReports {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(unique = true, nullable = false)
    private Long employee_id;

    @Column(nullable = false)
    private Long payroll_transaction_id;

    @Column(nullable = false)
    private String report_type;

    @Column(nullable = false)
    private String generated_by;

    @Column(nullable = false)
    private LocalDateTime generated_at;

    @Column(nullable = false)
    private String file_path;

}
