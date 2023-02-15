package com.example.products.controller;


import com.example.products.api.ApiResponse;
import com.example.products.model.MyUser;
import com.example.products.service.MyUserService;
import com.example.products.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class MyUserController {

    private final MyUserService myUserService;
    private final OrderService orderService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody MyUser myUser) {
        myUserService.userRegister(myUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("User registered!", 201));
    }

    // all
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login() {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Logged in successfully", 200));
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
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("User deleted!", 201));
    }

    @PostMapping("/{customer_id}/add-order/{order_id}")
    public ResponseEntity<ApiResponse> assignOrderToCustomer(@PathVariable Integer customer_id, @PathVariable Integer order_id, @AuthenticationPrincipal MyUser myUser) {
        orderService.assignOrderToCustomer(myUser, customer_id, order_id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("order assign to customer", 200));
    }

    @GetMapping("/all-orders/{customer_id}")
    public ResponseEntity getAllCustomerOrders(@PathVariable Integer customer_id, @AuthenticationPrincipal MyUser myUser) {
        return ResponseEntity.status(HttpStatus.OK).body(myUserService.getCustomerOrders(customer_id, myUser));
    }
}
