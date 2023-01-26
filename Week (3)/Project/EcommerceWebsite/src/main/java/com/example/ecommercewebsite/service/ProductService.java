package com.example.ecommercewebsite.service;


import com.example.ecommercewebsite.pojo.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product newProduct) {
        products.add(newProduct);
    }

    public boolean updateProduct(int id, Product updateProduct) {
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId() == id) {
                products.set(i, updateProduct);
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(int id) {
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId() == id) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }
}
