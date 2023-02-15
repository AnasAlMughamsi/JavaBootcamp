package com.example.products.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private int quantity;

    @NotNull
    private double totalPrice;

    private String dateReceived;

    @Pattern(regexp = "(new|inProgress|completed)", message = "product must has a status")
    @Column(columnDefinition = "varchar(20) not null check (status = 'new' or status = 'completed' or status = 'inProgress')")
    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @JsonIgnore
    private MyUser customer;

    @ManyToOne
    @JoinColumn(name = "order_product", referencedColumnName = "id")
    @JsonIgnore
    private Product product;


}
