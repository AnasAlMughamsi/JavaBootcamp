package com.example.ecommercewebsite.service;


import com.example.ecommercewebsite.pojo.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {

    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStocks() {
        return merchantStocks;
    }

    public void addMerchantStock(MerchantStock newMerchantStock) {
        merchantStocks.add(newMerchantStock);
    }

    public boolean updateMerchantStock(int id, MerchantStock updateMerchantStock) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if(merchantStocks.get(i).getMerchantID() == id) {
                merchantStocks.set(i, updateMerchantStock);
                return true;
            }
        }
        return false;
    }


    public boolean deleteMerchantStock(int id) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if(merchantStocks.get(i).getMerchantID() == id) {
                merchantStocks.remove(i);
                return true;
            }
        }
        return false;
    }
}
