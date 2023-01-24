package com.example.homework.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bank {
    private int id;
    private String username;
    private double balance;
}
