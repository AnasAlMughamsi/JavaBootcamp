package com.example.homework.model;

import com.example.homework.repository.AddressRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teachers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String name;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher_id")
    @PrimaryKeyJoinColumn
    Address address;
}
