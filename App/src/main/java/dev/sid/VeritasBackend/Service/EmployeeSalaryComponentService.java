package dev.sid.VeritasBackend.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.sid.VeritasBackend.DTO.EmployeeSalaryComponent.CreateEmployeeSalaryComponentDTO;
import dev.sid.VeritasBackend.DTO.EmployeeSalaryComponent.EmployeeSalaryComponentResponseDTO;
import dev.sid.VeritasBackend.DTO.EmployeeSalaryComponent.UpdateEmployeeSalaryComponentDTO;
import dev.sid.VeritasBackend.Entities.EmployeeSalaryComponents;
import dev.sid.VeritasBackend.Mapper.EmployeeSalaryComponentMapper;
import dev.sid.VeritasBackend.Repositories.EmployeeSalaryComponentRepository;

@Service
@Transactional(readOnly = true)
public class EmployeeSalaryComponentService {
  private final EmployeeSalaryComponentRepository employeeSalaryComponentRepository;
  private final EmployeeSalaryComponentMapper employeeSalaryComponentMapper;

  public EmployeeSalaryComponentService(EmployeeSalaryComponentRepository employeeSalaryComponentRepository,
      EmployeeSalaryComponentMapper employeeSalaryComponentMapper) {
    this.employeeSalaryComponentRepository = employeeSalaryComponentRepository;
    this.employeeSalaryComponentMapper = employeeSalaryComponentMapper;
  }

  @Transactional
  EmployeeSalaryComponentResponseDTO createEmployeeSalaryComponent(
      CreateEmployeeSalaryComponentDTO employeeSalaryComponentDto) {
    EmployeeSalaryComponents entity = employeeSalaryComponentMapper
        .toEntity(employeeSalaryComponentDto);
    employeeSalaryComponentRepository.save(entity);
    return employeeSalaryComponentMapper.toResponse(entity);
  }

  @Transactional
  public EmployeeSalaryComponentResponseDTO updateEmployeeSalaryComponent(Long id,
      UpdateEmployeeSalaryComponentDTO dto) {
    EmployeeSalaryComponents entity = employeeSalaryComponentRepository.findById(id).orElse(null);

    if (entity == null) {
      return null;
    }

    employeeSalaryComponentMapper.updateEntityFromDTO(dto, entity);

    return employeeSalaryComponentMapper.toResponse(entity);
  }

  @Transactional
  public void deleteEmployeeSalaryComponent(Long id) {
    employeeSalaryComponentRepository.deleteById(id);
  }
}
