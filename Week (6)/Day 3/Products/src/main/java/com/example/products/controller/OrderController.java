package com.example.products.controller;


import com.example.products.api.ApiResponse;
import com.example.products.model.MyUser;
import com.example.products.model.Order;
import com.example.products.repository.OrderRepository;
import com.example.products.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @GetMapping("/all")
    public ResponseEntity getAllOrder() {
        List<Order> orderList = orderService.getOrders();
        return ResponseEntity.status(200).body(orderList);
    }

    @GetMapping("/{order_id}")
    public ResponseEntity getOrderId(@PathVariable Integer order_id) {
        return ResponseEntity.status(200).body(orderService.getOrderById(order_id));
    }

    @PostMapping("/add/{product_id}")
    public ResponseEntity<ApiResponse> addOrder(@Valid @RequestBody Order order, @PathVariable Integer product_id, @AuthenticationPrincipal MyUser myUser) {
        orderService.addOrder(order, product_id, myUser);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Order added ", 200));
    }

    @PutMapping("/update/{order_id}")
    public ResponseEntity<ApiResponse> updateOrder(@AuthenticationPrincipal MyUser myUser, @Valid @RequestBody Order updateOrder, @PathVariable Integer order_id) {
        orderService.updateOrder(order_id, updateOrder, myUser);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Order updated! ", 200));
    }

    @DeleteMapping("/delete/{order_id}")
    public ResponseEntity<ApiResponse> deleteOrder(@PathVariable Integer order_id) {
        orderService.deleteOrder(order_id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Order deleted! ", 200));
    }

}
