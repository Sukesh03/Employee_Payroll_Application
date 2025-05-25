package com.example.employeepayrollapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class EmployeePayrollDTO {

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(
        regexp = "^[A-Z][a-zA-Z\\s]{2,}$",
        message = "Name must start with a capital letter and have at least 3 alphabetic characters"
    )
    private String name;

    @NotNull(message = "Salary cannot be null")
    @Min(value = 500, message = "Salary should be at least 500")
    private Long salary;
}
