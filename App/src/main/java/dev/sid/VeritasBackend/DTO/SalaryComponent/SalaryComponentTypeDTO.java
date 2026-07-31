package dev.sid.VeritasBackend.DTO.SalaryComponent;

import dev.sid.VeritasBackend.shared.ComponentTypes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SalaryComponentTypeDTO(
    @NotNull(message = "Id is required") Long id,
    @NotBlank(message = "Name is required") String name,
    ComponentTypes componentType) {
}
