package com.example.products.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Product name is required ")
    @Column(columnDefinition = "varchar(25) not null")
    private String name;
    @NotNull
    private double price;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Order> orderList;
}
