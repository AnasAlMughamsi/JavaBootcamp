package com.example.inclass.service;


import com.example.inclass.api.ApiException;
import com.example.inclass.model.Customer;
import com.example.inclass.model.Merchant;
import com.example.inclass.repository.CustomerRepository;
import com.example.inclass.repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final MerchantRepository merchantRepository;
    // add crud here
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Integer id, Customer updateCustomer) {
        Customer customer = customerRepository.findCustomerById(id);
        if(customer == null) {
            throw new ApiException("Wrong customer id");
        }
        updateCustomer.setId(id);
        customerRepository.save(updateCustomer);
    }
    public void deleteCustomer(Integer id) {
        Customer customer = customerRepository.findCustomerById(id);
        if(customer == null) {
            throw new ApiException("Wrong customer id");
        }
        customerRepository.delete(customer);
    }


    public void assignCustomerToMerchant(Integer customer_id, Integer merchant_id) {
        Customer customer = customerRepository.findCustomerById(customer_id);
        Merchant merchant = merchantRepository.findMerchantById(merchant_id);

        if(customer == null || merchant == null) {
            throw new ApiException("Wrong customer id or merchant id");
        }
        customer.getMerchants().add(merchant);
        merchant.getCustomers().add(customer);

        customerRepository.save(customer);
        merchantRepository.save(merchant);
    }
}
