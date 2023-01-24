package com.example.homework.controller;


import com.example.homework.pojo.Bank;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/vi/bank")
public class BankController {

    ArrayList<Bank> customers = new ArrayList<>();

    @GetMapping("/get-customer")
    public ArrayList<Bank> getCustomers() {
        return customers;
    }

    @PostMapping("add-customer")
    public String addCustomer(@RequestBody Bank newCustomer) {
        customers.add(newCustomer);
        return "New Customer added!";
    }

    @PutMapping("/update-customer/{index}")
    public String updateCustomer(@PathVariable int index, @RequestBody Bank customer) {
        customers.set(index, customer);
        return "customer updated!";
    }

    @DeleteMapping("/delete/{index}")
    public String deleteCustomer(@PathVariable int index) {
        customers.remove(index);
        return "Customer deleted!";
    }

    @PutMapping("/balance-deposit/{index}")
    public String deposit(@PathVariable int index, @RequestBody Bank customer) {
        double amount = 1000;
        double newBalance = customer.getBalance() + amount;
        customer.setBalance(newBalance);
        return "deposit amount of ";
    }
    @PutMapping("/balance-withdraw/{index}")
    public String withdraw(@PathVariable int index, @RequestBody Bank customer) {
        if(customer.getBalance() == 0) {
            return "Customer has no balance";
        }
        double withdrawAmount = 100;
        double newBalance = customer.getBalance() - withdrawAmount;
        customer.setBalance(newBalance);
        return "withdraw amount of ";
    }

}
