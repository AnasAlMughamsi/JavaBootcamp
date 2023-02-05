package com.example.inclass.repository;

import com.example.inclass.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Integer> {

    CustomerDetails findCustomerDetailsById(Integer id);

}
