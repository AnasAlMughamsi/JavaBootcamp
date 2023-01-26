package com.example.springday4.controller;


import com.example.springday4.api.ApiResponse;
import com.example.springday4.pojo.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/vi/users")
public class UserController {

    ArrayList<User> users = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<User> getUsers() {
        return users;
    }

//    ResponseEntity - return https status
    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors) {
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        users.add(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added!"));
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateUser(@PathVariable int index, @Valid @RequestBody User updateUser, Errors errors) {
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        users.set(index, updateUser);
        return ResponseEntity.status(200).body(new ApiResponse("User update"));
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteUser(@PathVariable int index) {
        users.remove(index);
        return new ApiResponse("User deleted!");
    }

}
