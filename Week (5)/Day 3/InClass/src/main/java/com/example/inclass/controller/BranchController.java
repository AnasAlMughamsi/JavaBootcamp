package com.example.inclass.controller;


import com.example.inclass.model.Branch;
import com.example.inclass.model.Merchant;
import com.example.inclass.service.BranchService;
import com.example.inclass.service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/branch")
public class BranchController {

    private final BranchService branchService;
    private final MerchantService merchantService;

    @GetMapping("/get")
    public ResponseEntity getBranchs() {
        List<Branch> branches = branchService.getBranches();
        return ResponseEntity.status(200).body(branches);
    }

    @PostMapping("/add")
    public ResponseEntity addMerchant(@Valid @RequestBody Branch updateBranch) {
        branchService.addBranch(updateBranch);
        return ResponseEntity.status(200).body("Branch added!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBranch(@PathVariable Integer id, @Valid @RequestBody Branch updateBranch) {
        branchService.updateBranch(id, updateBranch);
        return ResponseEntity.status(200).body("Branch updated!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBranch(@PathVariable Integer id) {
        branchService.deleteBranch(id);
        return ResponseEntity.status(200).body("Branch deleted!");
    }

    @PutMapping("/{merchant_id}/branch/{branch_id}")
    public ResponseEntity assignMerchantToBranch(@PathVariable Integer merchant_id, @PathVariable Integer branch_id) {
        merchantService.assignMerchantToBranch(merchant_id, branch_id);
        return ResponseEntity.status(200).body("assign branch to merchant");
    }
}
