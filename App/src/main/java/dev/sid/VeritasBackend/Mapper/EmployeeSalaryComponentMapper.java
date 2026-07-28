package dev.sid.VeritasBackend.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import dev.sid.VeritasBackend.DTO.EmployeeSalaryComponent.CreateEmployeeSalaryComponentDTO;
import dev.sid.VeritasBackend.DTO.EmployeeSalaryComponent.EmployeeSalaryComponentResponseDTO;
import dev.sid.VeritasBackend.DTO.EmployeeSalaryComponent.UpdateEmployeeSalaryComponentDTO;
import dev.sid.VeritasBackend.DTO.SalaryComponent.EmployeeSalaryComponentDTO;
import dev.sid.VeritasBackend.Entities.EmployeeSalaryComponents;

@Mapper(componentModel = "spring")
public interface EmployeeSalaryComponentMapper {
  CreateEmployeeSalaryComponentDTO toCreateDto(EmployeeSalaryComponentDTO entity);

  void updateEntityFromDTO(UpdateEmployeeSalaryComponentDTO dto,
      @MappingTarget EmployeeSalaryComponents entity);

  EmployeeSalaryComponents toEntity(CreateEmployeeSalaryComponentDTO dto);

  EmployeeSalaryComponentResponseDTO toResponse(EmployeeSalaryComponents entity);
}
