package dev.sid.VeritasBackend.Mapper;

import org.mapstruct.Mapper;

import dev.sid.VeritasBackend.DTO.PayrollTransactionItem.PayrollTransactionItemDTO;
import dev.sid.VeritasBackend.Entities.PayrollTransactionItems;

@Mapper(componentModel = "spring")
public interface PayrollTransactionItemsMapper {
  PayrollTransactionItemDTO toDto(PayrollTransactionItems payrollTransactionItem);

  PayrollTransactionItems toEntity(PayrollTransactionItemDTO payrollTransactionItemDTO);
}
