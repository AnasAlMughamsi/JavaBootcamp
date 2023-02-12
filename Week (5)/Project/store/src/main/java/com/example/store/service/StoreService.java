package com.example.store.service;

import com.example.store.api.ApiException;
import com.example.store.model.Book;
import com.example.store.model.Customer;
import com.example.store.model.Store;
import com.example.store.repository.BookRepository;
import com.example.store.repository.CustomerRepository;
import com.example.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final BookRepository bookRepository;
    private final CustomerRepository customerRepository;

    public List<Store> getStore() {
        return storeRepository.findAll();
    }

    public void addStore(Store store) {
        storeRepository.save(store);
    }

    public void updateStore(Integer id, Store updateStore) {
        Store store = storeRepository.findStoreById(id);
        if(store == null) {
            throw new ApiException("Store not found");
        }

        updateStore.setId(id);
        storeRepository.save(updateStore);
    }


    public void deleteStore(Integer id) {
        Store store = storeRepository.findStoreById(id);
        if(store == null) {
            throw new ApiException("Customer not found");
        }
        storeRepository.delete(store);
    }

    public List<Customer> showCustomers(Integer id) {
        Store store = storeRepository.findStoreById(id);
        if(store == null) {
            throw new ApiException("Store not found");
        }
        return store.getCustomers();
    }


    public List<Book> showBooks(Integer id) {
        Store store = storeRepository.findStoreById(id);
        if(store == null) {
            throw new ApiException("Store not found");
        }
        return store.getBooks();
    }
}
