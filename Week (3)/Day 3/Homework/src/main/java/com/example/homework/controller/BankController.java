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

    @PutMapping("/balance-deposit/{id}")
    public String deposit(@PathVariable int id) {
        if(customers.isEmpty()) {
            return "no customer found!";
        }
        double depositAmount = 1000;

        for (Bank customer : customers) {

            if(customer.getId() == id) {
                System.out.println("customer id: " + customer.getId() + " id from postman: " + id);
                double newBalance = customer.getBalance() + depositAmount;
                customer.setBalance(newBalance);
            }
        }

        return "deposit done";
    }
    @PutMapping("/balance-withdraw/{id}")
    public String withdraw(@PathVariable int id) {

        if(customers.isEmpty()) {
            return "no customer found!";
        }

        double withdrawAmount = 100;
        for (Bank customer : customers) {
            if(customer.getId() == id) {
                double newBalance = customer.getBalance() - withdrawAmount;
                customer.setBalance(newBalance);
            }
        }

        return "withdraw done";
    }

}
