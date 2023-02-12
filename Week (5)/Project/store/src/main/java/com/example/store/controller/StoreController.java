package com.example.store.controller;

import com.example.store.model.Book;
import com.example.store.model.Customer;
import com.example.store.model.Store;
import com.example.store.service.StoreService;
import com.example.store.service.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/get")
    public ResponseEntity getStore() {
        List<Store> stores = storeService.getStore();
        return ResponseEntity.status(200).body(stores);
    }

    @PostMapping("/add")
    public ResponseEntity addStore(@Valid @RequestBody Store store) {
        storeService.addStore(store);
        return ResponseEntity.status(200).body("Store added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStore(@PathVariable Integer id, @Valid @RequestBody Store updateStore) {
        storeService.updateStore(id, updateStore);
        return ResponseEntity.status(200).body("Store updated!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStore(@PathVariable Integer id) {
        storeService.deleteStore(id);
        return ResponseEntity.status(200).body("Store deleted!!");
    }

    @GetMapping("/get-customer/{id}")
    public ResponseEntity showCustomers(@PathVariable Integer id) {
        List<Customer> customers = storeService.showCustomers(id);
        return ResponseEntity.status(200).body(customers);
    }
    @GetMapping("/get-books/{id}")
    public ResponseEntity showBooks(@PathVariable Integer id) {
        List<Book> books = storeService.showBooks(id);
        return ResponseEntity.status(200).body(books);
    }


}
