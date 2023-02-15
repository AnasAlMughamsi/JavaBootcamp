package com.example.products.service;


import com.example.products.api.ApiException;
import com.example.products.model.MyUser;
import com.example.products.model.Product;
import com.example.products.repository.MyUserRepository;
import com.example.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final MyUserRepository myUserRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        Product product = productRepository.findProductById(id);
        if(product == null) {
            throw new ApiException("product not found!");
        }
        return product;
    }

    public void addProduct(Product product, Integer id) {
        MyUser myUser = myUserRepository.findMyUserById(id);
        if(myUser == null) {
            throw new ApiException("you are not the admin!");
        }
        productRepository.save(product);
    }

    public void updateProduct(Integer id, Product updateProduct) {
        Product product = productRepository.findProductById(id);
        if(product == null) {
            throw new ApiException("product not found!");
        }
        updateProduct.setId(id);
        productRepository.save(updateProduct);
    }

    public void deleteProduct(Integer id) {
        Product product = productRepository.findProductById(id);
        if(product == null) {
            throw new ApiException("product not found!");
        }
        productRepository.delete(product);
    }
}
