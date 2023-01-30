package com.example.homework.controller;

import com.example.homework.model.User;
import com.example.homework.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors) {
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User added!");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @Valid @RequestBody User updateUser, Errors errors) {
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUserUpdated = userService.updateUser(id, updateUser);
        if(isUserUpdated) {
            return ResponseEntity.status(200).body("User updated!");
        }
        return ResponseEntity.status(400).body("Can't updated user, wrong id!");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@PathVariable Integer id) {
        boolean isUserDeleted = userService.deleteUser(id);
        if (isUserDeleted) {
            return ResponseEntity.status(200).body("User deleted!!");
        } else {
            return ResponseEntity.status(400).body("Can't delete the user, Wrong Id!");
        }
    }
}
