package com.example.ecommercewebsite.controller;

import com.example.ecommercewebsite.pojo.Category;
import com.example.ecommercewebsite.pojo.Product;
import com.example.ecommercewebsite.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity getCategory() {
        ArrayList<Category> categories = categoryService.getCategories();
        return ResponseEntity.status(200).body(categories);
    }

    @PostMapping("/add")
    public ResponseEntity addCategory(@Valid @RequestBody Category addCategory, Errors errors) {
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryService.addCategory(addCategory);
        return ResponseEntity.status(200).body("Category added!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable int id, @Valid @RequestBody Category updateCategory, Errors errors) {
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isCategoryUpdated = categoryService.updateCategory(id, updateCategory);
        if(isCategoryUpdated) {
            return ResponseEntity.status(200).body("Category updated!");
        }
        return ResponseEntity.status(400).body("Can't update Category, Category not found!");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable int id) {
        boolean isCateDeleted = categoryService.deleteCategory(id);
        if(isCateDeleted) {
            return ResponseEntity.status(200).body("Category deleted!");
        }
        return ResponseEntity.status(400).body("Can't delete Category, Category not found");
    }
}
