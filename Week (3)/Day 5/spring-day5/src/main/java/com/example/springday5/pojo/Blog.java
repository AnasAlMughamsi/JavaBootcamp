package com.example.springday5.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data // provide getters/setters
@AllArgsConstructor
public class Blog {

    @NotNull(message = "id should not be null")
    private int id;
    @NotEmpty(message = "title should not be empty")
    private String title;
    @NotEmpty(message = "body should not be empty")
    private String body;
}
