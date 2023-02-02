package com.abdulrahman.project_4.User.controller;

import com.abdulrahman.project_4.User.model.User;
import com.abdulrahman.project_4.User.service.UserService;
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
    final UserService userService;
    @GetMapping("/get")
    public List<User> readUsers(){
        return userService.getUser();
    }
    @PostMapping("/add")
    public ResponseEntity createUsers(@RequestBody @Valid User user) {

        userService.addUser(user);
        return ResponseEntity.status(200).body("Added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUsers(@PathVariable Integer id, @RequestBody @Valid User user){

        userService.editUser(id, user);
        return ResponseEntity.status(200).body("User modified!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUsers(@PathVariable Integer id){

        userService.deleteUser(id);
        return ResponseEntity.status(200).body("User deleted!");

    }

    @PostMapping("/book-movie")
    public ResponseEntity userBookMovie() {


        return ResponseEntity.status(200).body("User booked a movie");
    }

}
