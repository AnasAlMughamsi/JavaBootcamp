package com.example.ecommercewebsite.controller;


import com.example.ecommercewebsite.pojo.MerchantStock;
import com.example.ecommercewebsite.pojo.Product;
import com.example.ecommercewebsite.pojo.User;
import com.example.ecommercewebsite.service.MerchantService;
import com.example.ecommercewebsite.service.MerchantStockService;
import com.example.ecommercewebsite.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final MerchantStockService merchantStockService;
    private final MerchantService merchantService;

    @GetMapping("/get")
    public ResponseEntity getUsers() {
        ArrayList<User> users = userService.getUsers();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User newUser, Errors errors) {
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.creatUser(newUser);
        return ResponseEntity.status(200).body("User Added!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable int id, @Valid @RequestBody User updateUser, Errors errors) {
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.updateUser(id,updateUser);
        return ResponseEntity.status(200).body("User updated!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        boolean isUserDeleted = userService.deleteUser(id);
        if(isUserDeleted) {
            return ResponseEntity.status(200).body("user deleted!");
        }
        return ResponseEntity.status(400).body("Can't delete user, user not found");
    }

    // Endpoint: make the user add product into merchant stock!
    @PostMapping("/add-product/{productID}/{merchantID}")
    public ResponseEntity userAddProduct(@PathVariable int productID, @PathVariable int merchantID) {
//        if(errors.hasErrors()) {
//            String message = errors.getFieldError().getDefaultMessage();
//            return ResponseEntity.status(400).body(message);
//        }

        // user take the product id and insert into merchantStock

        MerchantStock newStock = new MerchantStock();
        userService.userAddProduct(productID, merchantID, newStock);
        return ResponseEntity.status(200).body("Product add into the stock!");

    }


    // Endpoint: where user can buy a product.

    @PostMapping("/buy-product")
    public ResponseEntity buyProduct() {

        return ResponseEntity.status(200).body("User bought a product!");
    }
}
