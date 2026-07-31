package dev.sid.VeritasBackend.Config;

import org.example.PayrollEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PayrollConfig {
  @Bean
  public PayrollEngine payrollEngine() {
    return new PayrollEngine();
  }
}
