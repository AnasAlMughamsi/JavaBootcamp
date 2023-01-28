package com.example.ecommercewebsite.pojo;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    @NotNull(message = "user id must not be empty")
    @Digits(integer = 3, fraction = 0)
    private int id;

    @NotEmpty(message = "username must not be empty")
    @Size(min = 5, message = "username must at least has more then 5 characters")
    private String username;
    @NotEmpty(message = "password must not be empty")
    @Size(min = 5, message = "password must at least has more then 6 characters and digit")
    // add pattern to regex check
    private String password;

    @NotEmpty(message = "email must not be empty")
    @Email
    private String email;

    @NotEmpty(message = "role must not be empty")
    @Pattern(regexp = "Admin|Customer")
    private String role;

    @NotNull(message = "balance must not be empty")
    @Positive
    private int balance;
}
