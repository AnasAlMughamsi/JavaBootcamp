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
    public ResponseEntity getUser() {
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


    // new method - homework18

    @GetMapping("/getall")
    public ResponseEntity getAllUsers() {
        List<User> allUsers = userService.getAllUser();
        return ResponseEntity.status(200).body(allUsers);
    }
    @GetMapping("/getbyemail/{email}")
    public ResponseEntity getByEmail(@PathVariable String email) {
        User userByEmail =  userService.findByEmail(email);
        return ResponseEntity.status(200).body(userByEmail);
    }

    @GetMapping("/get-by-age/{age}")
    public ResponseEntity getByAge(@PathVariable int age) {
        List<User> userByAge =  userService.searchByAge(age);
        return ResponseEntity.status(200).body(userByAge);
    }

    @GetMapping("/get-by-role/{role}")
    public ResponseEntity getByRole(@PathVariable String role) {
        List<User> userRole = userService.searchAllByRole(role);
        return ResponseEntity.status(200).body(userRole);
    }


    @GetMapping("/check-ep")
    public ResponseEntity checkEmailPassword(User user) {
        userService.checkEmailPassword(user);
        return ResponseEntity.status(200).body("password and email are corrects");
    }
}
