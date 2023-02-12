package com.example.store.service;

import com.example.store.api.ApiException;
import com.example.store.model.Customer;
import com.example.store.model.Store;
import com.example.store.repository.CustomerRepository;
import com.example.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final StoreRepository storeRepository;

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

    public void assignCustomerToStore(Integer store_id, Integer customer_id) {
        Customer customer = customerRepository.findCustomerById(customer_id);
        Store store = storeRepository.findStoreById(store_id);

        if(store == null || customer == null) {
            throw new ApiException("Can't find customer or store");
        }
        customer.getStores().add(store);
        store.getCustomers().add(customer);
        storeRepository.save(store);
        customerRepository.save(customer);

    }

}
