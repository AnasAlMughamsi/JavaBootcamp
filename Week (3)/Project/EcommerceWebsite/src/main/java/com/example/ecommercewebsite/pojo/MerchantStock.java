package com.example.ecommercewebsite.pojo;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {

    @NotNull(message = "product id must not be empty")
    @Digits(integer = 3, fraction = 0)
    private int id;


    @NotNull(message = "product id must not be empty")
    @Digits(integer = 3, fraction = 0)
    private int productID;


    @NotNull(message = "product id must not be empty")
    @Digits(integer = 3, fraction = 0)
    private int merchantID;


    @NotNull(message = "product id must not be empty")
    private int stock = 11;

}
