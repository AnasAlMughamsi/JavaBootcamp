package com.example.inclass.repository;

import com.example.inclass.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {

    Branch findBranchById(Integer id);
}
