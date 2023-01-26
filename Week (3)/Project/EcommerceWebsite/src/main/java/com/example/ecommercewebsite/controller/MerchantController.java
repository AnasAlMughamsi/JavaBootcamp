package com.example.ecommercewebsite.controller;

import com.example.ecommercewebsite.pojo.Merchant;
import com.example.ecommercewebsite.pojo.Product;
import com.example.ecommercewebsite.service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    @GetMapping("/get")
    public ResponseEntity getMerchants() {
        ArrayList<Merchant> merchants = merchantService.getMerchants();
        return ResponseEntity.status(200).body(merchants);
    }

    @PostMapping("/add")
    public ResponseEntity addMerchant(@Valid @RequestBody Merchant newMerchant, Errors errors) {
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantService.addMerchant(newMerchant);
        return ResponseEntity.status(200).body("Merchants added!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@PathVariable int id, @Valid @RequestBody Merchant updateMerchant, Errors errors) {
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isMerchantUpdate = merchantService.updateMerchant(id, updateMerchant);
        if(isMerchantUpdate) {
            return ResponseEntity.status(200).body("Merchant updated!");
        }
        return ResponseEntity.status(400).body("Can't update merchant, merchant not found!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id) {
        boolean isMerchDeleted = merchantService.deleteMerchant(id);
        if(isMerchDeleted) {
            return ResponseEntity.status(200).body("Merchant deleted!");
        }
        return ResponseEntity.status(400).body("Can't delete merchant, merchant not found");
    }
}
