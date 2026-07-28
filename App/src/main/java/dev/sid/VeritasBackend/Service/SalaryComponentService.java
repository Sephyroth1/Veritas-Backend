package dev.sid.VeritasBackend.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.sid.VeritasBackend.DTO.SalaryComponent.SalaryComponentDTO;
import dev.sid.VeritasBackend.Entities.SalaryComponents;
import dev.sid.VeritasBackend.Mapper.SalaryComponentsMapper;
import dev.sid.VeritasBackend.Repositories.SalaryComponentsRepository;

@Service
@Transactional(readOnly = true)
public class SalaryComponentService {
  private final SalaryComponentsMapper salaryComponentsMapper;
  private final SalaryComponentsRepository salaryComponentsRepository;

  public SalaryComponentService(SalaryComponentsMapper salaryComponentsMapper,
      SalaryComponentsRepository salaryComponentsRepository) {
    this.salaryComponentsMapper = salaryComponentsMapper;
    this.salaryComponentsRepository = salaryComponentsRepository;
  }

  public SalaryComponentDTO getSalaryComponentById(Long id) {
    return salaryComponentsRepository.findById(id)
        .map(salaryComponentsMapper::toDto)
        .orElse(null);
  }

  @Transactional
  public SalaryComponentDTO createSalaryComponent(SalaryComponentDTO salaryComponentDto) {
    salaryComponentDto.id();
    SalaryComponents entity = salaryComponentsMapper.toEntity(salaryComponentDto);
    SalaryComponents savedEntity = salaryComponentsRepository.save(entity);

    return salaryComponentsMapper.toDto(savedEntity);
  }

  @Transactional
  public SalaryComponentDTO updateSalaryComponent(Long id, SalaryComponentDTO salaryComponentDto) {
    SalaryComponents exist = salaryComponentsRepository.findById(id).orElse(null);

    if (exist == null) {
      return null;
    }

    SalaryComponents updatedEntity = salaryComponentsMapper.updateEntityFromDTO(salaryComponentDto, exist);
    salaryComponentsRepository.save(updatedEntity);

    return salaryComponentsMapper.toDto(exist);
  }

  @Transactional
  public void deleteSalaryComponent(Long id) {
    salaryComponentsRepository.deleteById(id);
  }
}
