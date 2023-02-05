package com.example.inclass.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDetailsDTO {

    private Integer customer_id;
    private Integer age;
    private String phoneNumber;
    private String gender;


}
