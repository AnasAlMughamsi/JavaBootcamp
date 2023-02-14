package com.example.blog.controller;


import com.example.blog.api.ApiResponse;
import com.example.blog.model.MyUser;
import com.example.blog.service.MyUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class MyUserController {
    private final MyUserService myUserService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody MyUser myUser) {
        myUserService.userRegister(myUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("User registered!", 201));
    }

    // all
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login() {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("User Login", 200));
    }

    @PostMapping("/admin")
    public ResponseEntity<ApiResponse> admin() {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Welcome back admin!", 201));
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse> updateUser(@AuthenticationPrincipal MyUser myUser, @RequestBody @Valid MyUser updateMyUser) {
        myUserService.updateUser(myUser.getId(), updateMyUser);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Welcome back admin!", 201));
    }
    @DeleteMapping("/delete/{user_id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer user_id) {
        myUserService.deleteUser(user_id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Welcome back admin!", 201));
    }


    @GetMapping("/blogs/{user_id}")
    public ResponseEntity<ApiResponse> getUserBlogs(@PathVariable Integer user_id) {
        myUserService.getAllUserBlogs(user_id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Welcome back admin!", 201));
    }


}
