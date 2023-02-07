package com.example.inclass.service;


import com.example.inclass.api.ApiException;
import com.example.inclass.model.Branch;
import com.example.inclass.model.Merchant;
import com.example.inclass.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;

    public List<Branch> getBranches() {
        return branchRepository.findAll();
    }

    public void addBranch(Branch branch) {
        branchRepository.save(branch);
    }

    public void updateBranch(Integer id, Branch updateBranch) {
        Branch branch = branchRepository.findBranchById(id);
        if(branch == null) {
            throw new ApiException("Can't find the merchant");
        }
        updateBranch.setId(id);
        branchRepository.save(updateBranch);
    }

    public void deleteBranch(Integer id) {
        Branch branch = branchRepository.findBranchById(id);
        if(branch == null) {
            throw new ApiException("Can't find the merchant");
        }
        branchRepository.delete(branch);
    }
}
