package com.example.products.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class ApiResponse {
    private String message;
    private Integer status;

}
