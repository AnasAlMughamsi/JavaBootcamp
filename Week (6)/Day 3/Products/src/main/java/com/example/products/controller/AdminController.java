package com.example.products.controller;


import com.example.products.api.ApiResponse;
import com.example.products.model.MyUser;
import com.example.products.model.Order;
import com.example.products.service.MyUserService;
import com.example.products.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final MyUserService myUserService;
    private final OrderService orderService;

    @GetMapping("/all-users")
    public ResponseEntity getAllUsers() {
        return ResponseEntity.status(HttpStatus.CREATED).body(myUserService.myUsersList());
    }

    @GetMapping("/{user_id}")
    public ResponseEntity getMyCustomer(@PathVariable Integer user_id) {
        return ResponseEntity.status(200).body(myUserService.getUserById(user_id));
    }


    @PostMapping("/")
    public ResponseEntity<ApiResponse> admin() {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Welcome back admin!", 201));
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse> updateUser(@AuthenticationPrincipal MyUser myUser, @RequestBody @Valid MyUser updateMyUser) {
        myUserService.updateUser(myUser.getId(), updateMyUser);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("User updated!", 201));
    }
    @DeleteMapping("/delete/{user_id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer user_id) {
        myUserService.deleteUser(user_id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("User deleted!", 201));
    }

    @PutMapping("/order-status/{order_id}/{status}")
    public ResponseEntity<ApiResponse> changeOrderStatus(@PathVariable Integer order_id, @AuthenticationPrincipal MyUser admin, String status) {
        orderService.changeStatus(order_id, status, admin);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("User deleted!", 201));
    }


}
