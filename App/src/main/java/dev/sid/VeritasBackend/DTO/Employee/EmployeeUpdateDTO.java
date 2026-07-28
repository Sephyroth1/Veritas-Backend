package dev.sid.VeritasBackend.DTO.Employee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmployeeUpdateDTO(
        @NotBlank(message = "First Name is required") String firstName,
        @NotBlank(message = "Last Name is required") String lastName,
        @NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email,
        @NotBlank(message = "Department is required") String department,
        @NotBlank(message = "Designation is required") String designation,
        @NotBlank(message = "Employment Type is required") String employmentType) {
}
