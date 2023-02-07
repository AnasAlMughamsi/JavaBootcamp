package com.example.inclass.repository;


import com.example.inclass.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface MerchantRepository extends JpaRepository<Merchant, Integer> {

    Merchant findMerchantById(Integer id);
}
