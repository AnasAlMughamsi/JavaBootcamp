package com.example.employeesmanagement.pojo;

import jakarta.validation.constraints.*;
import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
public class Employee {
    @NotNull(message = "id cannot be null")
    @Range(min = 10, message = "id should more then 2 digits.")
    private int id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 4, message = "name should have more then 4 letters.")
    private String name;

    @NotNull(message = "age cannot be null")
    @Min(value = 25, message = "age should be more then 24")
    @Digits(integer = 2, fraction = 0, message = "age should be only two digit.")
    private int age;

    @NotEmpty(message = "role cannot be empty")
    @Pattern(regexp = "supervisor|Supervisor|coordinator|Coordinator")
    private String role;

    private boolean onLeave = false;

    @NotNull(message = "employment year cannot be null")
    @Digits(integer = 4, fraction = 0)
    @Range(min = 1990, max = 2023)
    private int employmentYear;

    @NotNull(message = "annual leave cannot be null")
    @Range(min = 0, max = 1, message = "value of annual leave should be  1 or 0")
    @Positive
    private int annualLeave;


}
