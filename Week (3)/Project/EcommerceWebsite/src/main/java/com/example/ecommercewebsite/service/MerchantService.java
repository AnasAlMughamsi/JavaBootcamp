package com.example.ecommercewebsite.service;

import com.example.ecommercewebsite.pojo.Category;
import com.example.ecommercewebsite.pojo.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {

    ArrayList<Merchant> merchants = new ArrayList<>();

    public ArrayList<Merchant> getMerchants() {
        return merchants;
    }

    public void addMerchant(Merchant newMerchant) {
        merchants.add(newMerchant);
    }

    public boolean updateMerchant(int id, Merchant updateMerchant) {
        for (int i = 0; i < merchants.size(); i++) {
            if(merchants.get(i).getId() == id) {
                merchants.set(i, updateMerchant);
                return true;
            }
        }
        return false;
    }


    public boolean deleteMerchant(int id) {
        for (int i = 0; i < merchants.size(); i++) {
            if(merchants.get(i).getId() == id) {
                merchants.remove(i);
                return true;
            }
        }
        return false;
    }
}
