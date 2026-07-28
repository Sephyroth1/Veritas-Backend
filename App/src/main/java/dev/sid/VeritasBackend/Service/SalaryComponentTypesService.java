package dev.sid.VeritasBackend.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.sid.VeritasBackend.DTO.SalaryComponent.SalaryComponentTypeDTO;
import dev.sid.VeritasBackend.Entities.SalaryComponentTypes;
import dev.sid.VeritasBackend.Mapper.SalaryComponentTypesMapper;
import dev.sid.VeritasBackend.Repositories.SalaryComponentTypesRepository;

@Service
@Transactional(readOnly = true)
public class SalaryComponentTypesService {
  private final SalaryComponentTypesRepository salaryComponentTypesRepository;
  private final SalaryComponentTypesMapper salaryComponentTypesMapper;

  public SalaryComponentTypesService(SalaryComponentTypesRepository salaryComponentTypesRepository,
      SalaryComponentTypesMapper salaryComponentTypesMapper) {
    this.salaryComponentTypesRepository = salaryComponentTypesRepository;
    this.salaryComponentTypesMapper = salaryComponentTypesMapper;
  }

  @Transactional
  public SalaryComponentTypeDTO createSalaryComponentTypeDTO(SalaryComponentTypeDTO salaryComponentTypeDto) {
    salaryComponentTypeDto.id();
    var entity = salaryComponentTypesMapper.toEntity(salaryComponentTypeDto);
    SalaryComponentTypes savedEntity = salaryComponentTypesRepository.save(entity);

    return salaryComponentTypesMapper.toDto(savedEntity);

  }

  @Transactional
  public SalaryComponentTypeDTO updateSalaryComponentTypeDTO(Long id, SalaryComponentTypeDTO salaryComponentTypeDto) {
    var entity = salaryComponentTypesRepository.findById(id).orElse(null);
    if (entity == null) {
      return null;
    }

    SalaryComponentTypes updatedEntity = salaryComponentTypesMapper.updateEntityFromDTO(salaryComponentTypeDto, entity);

    return salaryComponentTypesMapper.toDto(updatedEntity);
  }

  @Transactional
  public void deleteSalaryComponentTypeDTO(Long id) {
    salaryComponentTypesRepository.deleteById(id);
  }
}
