package com.example.inclass.controller;


import com.example.inclass.model.Merchant;
import com.example.inclass.service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    // add curd endpoint

    @GetMapping("/get")
    public ResponseEntity getMerchant() {
        List<Merchant> merchants = merchantService.getMerchant();
        return ResponseEntity.status(200).body(merchants);
    }

    @PostMapping("/add")
    public ResponseEntity addMerchant(@Valid @RequestBody Merchant merchant) {
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body("Merchant added!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@PathVariable Integer id, @Valid @RequestBody Merchant updateMerchant) {
        merchantService.updateMerchant(id, updateMerchant);
        return ResponseEntity.status(200).body("Merchant updated!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable Integer id) {
        merchantService.deleteMerchant(id);
        return ResponseEntity.status(200).body("Merchant deleted!");
    }


}
