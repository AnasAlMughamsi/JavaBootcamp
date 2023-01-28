package com.example.ecommercewebsite.pojo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @NotNull(message = "product id must not be empty")
    @Digits(integer = 3, fraction = 0)
    private int id;
    @NotEmpty(message = "product name must not be empty")
    @Size(min = 3, message = "product name must at least has more then 2 characters")
    private String name;

    @NotNull(message = "product price must not be empty")
    @Positive
    private double price;

    @NotNull(message = "categoryID in product must not be empty")
    @Digits(integer = 3, fraction = 0)
    private int categoryID;
}
