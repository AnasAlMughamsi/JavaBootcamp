package com.example.homework.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeacherAddressDTO {

    private Integer teacher_id;
    private String area;
    private String street;
    private int buildingNumber;
}

