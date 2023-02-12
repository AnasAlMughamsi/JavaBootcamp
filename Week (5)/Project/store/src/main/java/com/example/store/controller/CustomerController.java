package com.example.store.controller;

import com.example.store.model.Customer;
import com.example.store.service.CustomerService;
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
    public ResponseEntity getCustomer() {
        List<Customer> customers = customerService.getCustomers();
        return ResponseEntity.status(200).body(customers);
    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@Valid @RequestBody Customer course) {
        customerService.addCustomer(course);
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
        return ResponseEntity.status(200).body("Customer deleted!!");
    }

    @PostMapping("{store_id}/assign-store/{customer_id}")
    public ResponseEntity assignCustomerToStore(@PathVariable Integer customer_id,@PathVariable Integer store_id ) {
        customerService.assignCustomerToStore(store_id, customer_id);
        return ResponseEntity.status(200).body("Assign customer to store");
    }
}
