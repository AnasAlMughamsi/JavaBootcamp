package com.example.inclass.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerDetails {

    @Id
    private Integer id;
    private Integer age;
    private String phoneNumber;
    private String gender;

    @OneToOne
    @MapsId
    @JsonIgnore // need explanation!
    private Customer customer;


}
