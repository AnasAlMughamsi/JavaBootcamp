package com.example.ecommercewebsite.service;


import com.example.ecommercewebsite.pojo.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {

    ArrayList<Category> categories = new ArrayList<>();

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category addCategory) {
        categories.add(addCategory);
    }

    public boolean updateCategory(int id, Category updateCategory) {
        for (int i = 0; i < categories.size(); i++) {
            if(categories.get(i).getId() == id) {
                categories.set(i, updateCategory);
                return true;
            }
        }
        return false;
    }


    public boolean deleteCategory(int id) {
        for (int i = 0; i < categories.size(); i++) {
            if(categories.get(i).getId() == id) {
                categories.remove(i);
                return true;
            }
        }
        return false;
    }
}
