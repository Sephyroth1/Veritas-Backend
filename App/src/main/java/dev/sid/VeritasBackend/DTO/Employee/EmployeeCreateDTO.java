package dev.sid.VeritasBackend.DTO.Employee;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmployeeCreateDTO(
        @NotBlank(message = "Employee code is required") Long employeeCode,
        @NotBlank(message = "First name is required") String firstName,
        @NotBlank(message = "Last name is required") String lastName,
        @NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email,
        @NotBlank(message = "Department is required") String department,
        @NotBlank(message = "Designation is required") String designation,
        @NotBlank(message = "Employment type is required") String employmentType,
        @NotBlank(message = "Date of joining is required") LocalDate dateOfJoining) {
}
