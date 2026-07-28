package dev.sid.VeritasBackend.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import dev.sid.VeritasBackend.DTO.PayrollTransaction.PayrollTransactionDTO;
import dev.sid.VeritasBackend.Entities.PayrollTransactions;

@Mapper(componentModel = "spring")
public interface PayrollTransactionMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "employeeId", ignore = true)
  @Mapping(target = "payPeriod", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  PayrollTransactions toEntity(PayrollTransactionDTO payrollTransactionDTO);

  PayrollTransactionDTO toDto(PayrollTransactionDTO payrollTransaction);
}
