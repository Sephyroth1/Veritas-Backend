package dev.sid.VeritasBackend.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import dev.sid.VeritasBackend.DTO.SalaryComponent.SalaryComponentDTO;
import dev.sid.VeritasBackend.Entities.SalaryComponents;

@Mapper(componentModel = "spring")
public interface SalaryComponentsMapper {
  @Mapping(target = "specialAllowance", ignore = true)
  SalaryComponentDTO toDto(SalaryComponents salaryComponents);

  @Mapping(target = "employeeId", ignore = true)
  @Mapping(target = "specialAllowances", ignore = true)
  @Mapping(target = "effectiveFrom", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  SalaryComponents toEntity(SalaryComponentDTO salaryComponentsDto);

  @Mapping(target = "employeeId", ignore = true)
  @Mapping(target = "specialAllowances", ignore = true)
  @Mapping(target = "effectiveFrom", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  SalaryComponents updateEntityFromDTO(SalaryComponentDTO salaryComponentsDto,
      @MappingTarget SalaryComponents salaryComponents);
}
