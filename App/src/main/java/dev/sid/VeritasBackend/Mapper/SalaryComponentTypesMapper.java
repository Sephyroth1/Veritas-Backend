package dev.sid.VeritasBackend.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import dev.sid.VeritasBackend.DTO.SalaryComponent.SalaryComponentTypeDTO;
import dev.sid.VeritasBackend.Entities.SalaryComponentTypes;

@Mapper(componentModel = "spring")
public interface SalaryComponentTypesMapper {
  SalaryComponentTypeDTO toDto(SalaryComponentTypes entity);

  SalaryComponentTypes toEntity(SalaryComponentTypeDTO dto);

  SalaryComponentTypes updateEntityFromDTO(SalaryComponentTypeDTO dto, @MappingTarget SalaryComponentTypes entity);
}
