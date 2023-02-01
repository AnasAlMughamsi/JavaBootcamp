package com.example.homework.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "username is required")
    @Size(message = "username length must more then 3 characters")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String username;

    @NotNull(message = "password is required")
    @Column(columnDefinition = "varchar(30) not null")
    private String password;

    @NotNull(message = "email is required")
    @Column(columnDefinition = "varchar(25) not null unique")
    @Email
    private String email;

    @NotEmpty(message = "role is required")
    @Pattern(regexp = "user|admin")
    @Column(columnDefinition = "varchar(30) not null check ( role='user' or role='admin' )")
    private String role;

    @NotNull(message = "Aage is required")
    @Column(columnDefinition = "varchar(5) not null")
    private int age;

}
