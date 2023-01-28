package com.example.ecommercewebsite.service;


import com.example.ecommercewebsite.pojo.Merchant;
import com.example.ecommercewebsite.pojo.MerchantStock;
import com.example.ecommercewebsite.pojo.Product;
import com.example.ecommercewebsite.pojo.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    ArrayList<User> users = new ArrayList<>();
    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Merchant> merchants = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }

    public void creatUser(User newUser) {
        users.add(newUser);
    }

    public boolean updateUser(int id, User updateUser) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId() == id) {
                users.set(i, updateUser);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(int id) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId() == id) {
                users.remove(i);
                return true;
            }
        }
        return false;
    }

    // method to accept user to add product into merchantStock
    public void userAddProduct(int productId, int merchantId, MerchantStock merchantStock) {

        Product newProduct = new Product();
        Merchant newMerchant = new Merchant();
        if(newProduct.getId() == productId && newMerchant.getId() == merchantId) {
            merchantStock.setStock(productId);
        }

    }


    public void buyProduct(int userId, int productId, int merchantId) {

    }

}
