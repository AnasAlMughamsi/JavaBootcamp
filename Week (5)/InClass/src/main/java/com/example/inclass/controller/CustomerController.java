package com.example.inclass.controller;


import com.example.inclass.dto.CustomerDetailsDTO;
import com.example.inclass.model.Customer;
import com.example.inclass.service.CustomerService;
import jakarta.validation.Path;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/get")
    public ResponseEntity getCustomers() {
        List<Customer> customers = customerService.getCustomers();
        return ResponseEntity.status(200).body(customers);
    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@Valid @RequestBody Customer addCustomer) {
        customerService.addCustomer(addCustomer);
        return ResponseEntity.status(200).body("Customer added!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id, @Valid @RequestBody Customer updateCustomer) {
        customerService.updateCustomer(id, updateCustomer);
        return ResponseEntity.status(200).body("customer updated!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body("Customer deleted!!");
    }


    // method relate it to customer details
    @PostMapping("/add-details")
    public ResponseEntity addDetails(@Valid @RequestBody CustomerDetailsDTO ct) {
        customerService.addCustomerDetails(ct);
        return ResponseEntity.status(200).body("Details added!!!");
    }

    @PutMapping("/update-details")
    public ResponseEntity updateDetails(@Valid @RequestBody CustomerDetailsDTO ct) {
        customerService.updateCustomerDetails(ct);
        return ResponseEntity.status(200).body("update details!");
    }

    @DeleteMapping("/delete-details/{id}")
    public ResponseEntity deleteDetails(@PathVariable Integer id) {
        customerService.deleteCustomerDetails(id);
        return ResponseEntity.status(200).body("customer deleted!");
    }
}
