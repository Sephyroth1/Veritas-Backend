package dev.sid.VeritasBackend.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.sid.VeritasBackend.DTO.PayrollEngine.PayrollEngineDTORequest;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

import org.example.PayrollEngine;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PayrollEngineController {
  private final PayrollEngine payrollEngine;

  @PostMapping("/evaluate")
  public ResponseEntity<Map<String, BigDecimal>> evaluate(@RequestBody PayrollEngineDTORequest request) {
    Map<String, BigDecimal> res = payrollEngine.evaluate(request.rules());
    return ResponseEntity.ok(res);
  }
}
