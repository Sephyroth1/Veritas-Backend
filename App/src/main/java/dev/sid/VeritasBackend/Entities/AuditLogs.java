package dev.sid.VeritasBackend.Entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AuditLogs {
  List<Integer> temp = new ArrayList<>();
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(nullable = false)
  private String user_id;

  @Column(nullable = false)
  private String action;

  @Column(nullable = false)
  private String entity_name;

  @Column(nullable = false)
  private String entity_id;

  @Column(nullable = false)
  private String old_value;

  @Column(nullable = false)
  private String new_value;

  @Column(nullable = false)
  private LocalDateTime timestamp;

  @Column(nullable = false)
  private String details;
}
