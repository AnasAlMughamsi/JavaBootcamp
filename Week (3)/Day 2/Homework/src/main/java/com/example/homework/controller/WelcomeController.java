package com.example.homework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/name")
    public String getName() {
        return "My name is Anas";
    }

    @GetMapping("/age")
    public String getAge() {
        return "My age is 27";
    }

    @GetMapping("/check/status")
    public String getStatus() {
        return "Everything is great";
    }

    @GetMapping("/health")
    public String getHealth() {
        return "Server health is up and running";
    }
}
