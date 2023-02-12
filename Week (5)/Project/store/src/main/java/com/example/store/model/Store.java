package com.example.store.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String name;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "store")
    @PrimaryKeyJoinColumn
    Location location;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Book> books;

    @ManyToMany(mappedBy = "stores")
    private List<Customer> customers;
}
