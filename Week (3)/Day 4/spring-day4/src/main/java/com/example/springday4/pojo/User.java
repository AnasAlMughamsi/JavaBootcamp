package com.example.springday4.pojo;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private int id;
    @NotEmpty(message = "user name shouldn't be empty")
    @Size(min = 4, max = 8, message = "name should at least has more then 3 or less then 8 letters")
    private String name;
    @NotEmpty(message = "password should not be empty")
    private String password;
}
