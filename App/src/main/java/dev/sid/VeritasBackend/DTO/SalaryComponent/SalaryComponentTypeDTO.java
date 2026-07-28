package dev.sid.VeritasBackend.DTO.SalaryComponent;

import org.hibernate.type.ComponentType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SalaryComponentTypeDTO(
    @NotNull(message = "Id is required") Long id,
    @NotBlank(message = "Name is required") String name,
    ComponentType componentType) {
}
