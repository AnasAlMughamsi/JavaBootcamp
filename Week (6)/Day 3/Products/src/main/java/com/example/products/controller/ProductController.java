package com.example.products.controller;

import com.example.products.api.ApiResponse;
import com.example.products.model.MyUser;
import com.example.products.model.Product;
import com.example.products.model.Product;
import com.example.products.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity getAllProduct() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.status(200).body(products);
    }

    @GetMapping("/{product_id}")
    public ResponseEntity getProductId(@PathVariable Integer product_id) {
        return ResponseEntity.status(200).body(productService.getProductById(product_id));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@Valid @RequestBody Product product, @AuthenticationPrincipal MyUser myUser) {
        productService.addProduct(product, myUser.getId());
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Product added ", 200));
    }

    @PutMapping("/update/{product_id}")
    public ResponseEntity<ApiResponse> updateProduct(@Valid @RequestBody Product updateProduct, @PathVariable Integer product_id) {
        productService.updateProduct(product_id, updateProduct);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Product updated! ", 200));
    }

    @DeleteMapping("/delete/{product_id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Integer product_id) {
        productService.deleteProduct(product_id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Product deleted! ", 200));
    }
}
