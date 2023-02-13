package com.example.auth01.controller;

import com.example.auth01.dto.Response;
import com.example.auth01.model.MyUser;
import com.example.auth01.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody MyUser myUser) {
        authService.register(myUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response("User registered!", 201));
    }
    @PostMapping("/admin")
    public ResponseEntity<Response> admin() {
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Welcome back admin!", 201));
    }
    @PostMapping("/user")
    public ResponseEntity<Response> user() {
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Welcome back user!", 201));
    }

    @PostMapping("/login")
    public ResponseEntity<Response> login() {
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Welcome back!", 201));
    }
    @PostMapping("/logout")
    public ResponseEntity<Response> logout() {
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Log out!", 201));
    }
}
