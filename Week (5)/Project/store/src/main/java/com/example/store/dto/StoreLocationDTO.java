package com.example.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StoreLocationDTO {

    private Integer store_id;
    private String area;
    private String street;
}
