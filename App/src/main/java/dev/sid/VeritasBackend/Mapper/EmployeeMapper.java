package dev.sid.VeritasBackend.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import dev.sid.VeritasBackend.DTO.Employee.EmployeeCreateDTO;
import dev.sid.VeritasBackend.DTO.Employee.EmployeeDetailsDTO;
import dev.sid.VeritasBackend.DTO.Employee.EmployeeSummaryDTO;
import dev.sid.VeritasBackend.DTO.Employee.EmployeeUpdateDTO;
import dev.sid.VeritasBackend.Entities.Employees;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EmployeeMapper {
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "name", ignore = true)
  EmployeeSummaryDTO toSummaryDTO(Employees employee);

  @Mapping(target = "name", ignore = true)
  @Mapping(target = "salaryComponents", ignore = true)
  EmployeeDetailsDTO toDetailsDTO(Employees employee);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  Employees toEntity(EmployeeCreateDTO dto);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "employeeCode", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  @Mapping(target = "dateOfJoining", ignore = true)
  void updateEntity(EmployeeUpdateDTO dto, @MappingTarget Employees employee);
}
