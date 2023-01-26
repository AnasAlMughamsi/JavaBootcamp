package com.example.ecommercewebsite.controller;


import com.example.ecommercewebsite.pojo.Category;
import com.example.ecommercewebsite.pojo.MerchantStock;
import com.example.ecommercewebsite.service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/merchant-stock")
public class MerchantStockController {

    private final MerchantStockService merchantStockService;

    @GetMapping("/get")
    public ResponseEntity getMerchantStock() {
        ArrayList<MerchantStock> merchantStocks = merchantStockService.getMerchantStocks();
        return ResponseEntity.status(200).body(merchantStocks);
    }

    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@Valid @RequestBody MerchantStock newMerchantStock, Errors errors) {
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantStockService.addMerchantStock(newMerchantStock);
        return ResponseEntity.status(200).body("Merchant stock added!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchantStock(@PathVariable int id, @Valid @RequestBody MerchantStock updateMerchantStock, Errors errors) {
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isMerchStockUpdated = merchantStockService.updateMerchantStock(id, updateMerchantStock);
        if(isMerchStockUpdated) {
            return ResponseEntity.status(200).body("Merchant stock updated!");
        }
        return ResponseEntity.status(400).body("Can't update merchant stock, merchant stock not found!");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable int id) {
        boolean isMerchStockDeleted = merchantStockService.deleteMerchantStock(id);
        if(isMerchStockDeleted) {
            return ResponseEntity.status(200).body("merchant stock deleted!");
        }
        return ResponseEntity.status(400).body("Can't delete merchant stock, merchant stock not found");
    }
}
