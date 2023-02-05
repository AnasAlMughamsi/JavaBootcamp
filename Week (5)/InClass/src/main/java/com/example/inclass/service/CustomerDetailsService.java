package com.example.inclass.service;


import com.example.inclass.api.ApiException;
import com.example.inclass.model.Customer;
import com.example.inclass.model.CustomerDetails;
import com.example.inclass.repository.CustomerDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService {

    private final CustomerDetailsRepository customerDetailsRepository;
    public List<CustomerDetails> getCustomersDetails() {
        return customerDetailsRepository.findAll();
    }

    public void addCustomerDetails(CustomerDetails customerDetails) {
        customerDetailsRepository.save(customerDetails);
    }

    public void updateCustomerDetails(Integer id, CustomerDetails updateCT) {
        CustomerDetails customerDetails = customerDetailsRepository.findCustomerDetailsById(id);
        if(customerDetails == null) {
            throw new ApiException("Customer details not found");
        }
        updateCT.setId(id);
        customerDetailsRepository.save(updateCT);
    }

    public void deleteCustomerDelete(Integer id) {
        CustomerDetails customerDetails = customerDetailsRepository.findCustomerDetailsById(id);
        if(customerDetails == null) {
            throw new ApiException("Customer not found");
        }
        customerDetailsRepository.delete(customerDetails);
    }

}
