package com.example.inclass.controller;


import com.example.inclass.model.Customer;
import com.example.inclass.model.Merchant;
import com.example.inclass.service.CustomerService;
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


    // add crud here

    @GetMapping("/get")
    public ResponseEntity getCustomers() {
        List<Customer> customers = customerService.getCustomers();
        return ResponseEntity.status(200).body(customers);
    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@Valid @RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body("Customer added!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id, @Valid @RequestBody Customer updateCustomer) {
        customerService.updateCustomer(id, updateCustomer);
        return ResponseEntity.status(200).body("Customer updated!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body("Customer deleted!");
    }

    @PostMapping("/{customer_id}/customer/{merchant_id}")
    public ResponseEntity assignCustomerToMerchant(@PathVariable Integer customer_id, @PathVariable Integer merchant_id) {
        customerService.assignCustomerToMerchant(customer_id, merchant_id);
        return ResponseEntity.status(200).body("customer assign to merchant!");

    }
}
