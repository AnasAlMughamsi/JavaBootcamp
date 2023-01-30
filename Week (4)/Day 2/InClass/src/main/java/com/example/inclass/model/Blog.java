package com.example.inclass.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "shouldn't be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String title;
    @NotEmpty(message = "shouldn't be empty")
    @Column(columnDefinition = "varchar(300) not null")
    private String body;
}
