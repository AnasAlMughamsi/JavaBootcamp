package com.example.employeesmanagement.controller;

import com.example.employeesmanagement.api.ApiResponse;
import com.example.employeesmanagement.pojo.Employee;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/vi/employee")
public class EmployeeController {

    ArrayList<Employee> employees = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    @PostMapping("/add")
    public ResponseEntity addEmployee(@Valid @RequestBody Employee newEmployee, Errors errors) {
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        employees.add(newEmployee);
        return ResponseEntity.status(200).body(new ApiResponse("Employee add"));
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateUser(@PathVariable int index, @Valid @RequestBody Employee updateEmployee, Errors errors) {
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        employees.set(index, updateEmployee);
        return ResponseEntity.status(200).body(new ApiResponse("Employee updated"));
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteEmployee(@PathVariable int index) {
        employees.remove(index);
        return new ApiResponse("Employee deleted!");
    }


    // new endpoint to check annual leave!
    @PutMapping("/annual-leave/{id}")
    public ResponseEntity updateAnnualLeave(@PathVariable int id) {

        for (Employee employee : employees) {
            if(employee.getId() == id) {
                if(employee.getAnnualLeave() == 0) {
                    return ResponseEntity.status(400).body(new ApiResponse("Employee already take annual leave!"));

                } else if(employee.isOnLeave()) {
                    return ResponseEntity.status(400).body(new ApiResponse("تراك في اجازة!"));
                }
                employee.setOnLeave(true);
                employee.setAnnualLeave(employee.getAnnualLeave() - 1); // make it 0
                return ResponseEntity.status(200).body(new ApiResponse("Go. you are free!... but come back later"));
            }
        }
        return ResponseEntity.status(400).body(new ApiResponse("id not found"));
    }


}
