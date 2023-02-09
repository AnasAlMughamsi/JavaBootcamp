package com.example.inclass.service;


import com.example.inclass.api.ApiException;
import com.example.inclass.model.Branch;
import com.example.inclass.model.Merchant;
import com.example.inclass.repository.BranchRepository;
import com.example.inclass.repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {

    private final MerchantRepository merchantRepository;
    private final BranchRepository branchRepository;
    // add crud

    public List<Merchant> getMerchant() {
        return merchantRepository.findAll();
    }

    public void addMerchant(Merchant merchant) {
        merchantRepository.save(merchant);
    }

    public void updateMerchant(Integer id, Merchant updateMerchant) {
        Merchant merchant = merchantRepository.findMerchantById(id);
        if(merchant == null) {
            throw new ApiException("Can't find the merchant");
        }
        updateMerchant.setId(id);
        merchantRepository.save(updateMerchant);
    }

    public void deleteMerchant(Integer id) {
        Merchant merchant = merchantRepository.findMerchantById(id);
        if(merchant == null) {
            throw new ApiException("Can't find the merchant");
        }
        merchantRepository.delete(merchant);
    }

    public void assignMerchantToBranch(Integer merchant_id, Integer branch_id) {
        Merchant merchant = merchantRepository.findMerchantById(merchant_id);
        Branch branch = branchRepository.findBranchById(branch_id);

        if(merchant == null || branch == null) {
            throw new ApiException("Can't find merchant or branch");
        }

        branch.setMerchant(merchant);
        branchRepository.save(branch);
    }

}
