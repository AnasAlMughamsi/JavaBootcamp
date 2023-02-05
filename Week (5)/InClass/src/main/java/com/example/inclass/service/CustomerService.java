package com.example.inclass.service;

import com.example.inclass.api.ApiException;
import com.example.inclass.dto.CustomerDetailsDTO;
import com.example.inclass.model.Customer;
import com.example.inclass.model.CustomerDetails;
import com.example.inclass.repository.CustomerDetailsRepository;
import com.example.inclass.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDetailsRepository customerDetailsRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Integer id, Customer updateCustomer) {
        Customer customer = customerRepository.findCustomerById(id);
        if(customer == null) {
            throw new ApiException("Customer not found");
        }
        updateCustomer.setId(id);
        customerRepository.save(updateCustomer);
    }

    public void deleteCustomer(Integer id) {
        Customer customer = customerRepository.findCustomerById(id);
        if(customer == null) {
            throw new ApiException("Customer not found");
        }
        customerRepository.delete(customer);
    }

    // new method using DTO and OneToOne relationship
    public void addCustomerDetails(CustomerDetailsDTO cd) {
        Customer customer = customerRepository.findCustomerById(cd.getCustomer_id());
        if(customer == null) {
            throw new ApiException("Customer not found!");
        }
        CustomerDetails customerDetails = new CustomerDetails(null, cd.getAge(), cd.getPhoneNumber(), cd.getGender(), customer);
        customerDetailsRepository.save(customerDetails);
    }
}
