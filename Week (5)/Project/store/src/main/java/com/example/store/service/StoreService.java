package com.example.store.service;

import com.example.store.api.ApiException;
import com.example.store.dto.StoreLocationDTO;
import com.example.store.model.Book;
import com.example.store.model.Customer;
import com.example.store.model.Location;
import com.example.store.model.Store;
import com.example.store.repository.BookRepository;
import com.example.store.repository.CustomerRepository;
import com.example.store.repository.LocationRepository;
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
    private final LocationRepository locationRepository;

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
            throw new ApiException("Store not found");
        }
        storeRepository.delete(store);
    }

    // =============================== DTO - END =============================== //

    public void addStoreLocation(StoreLocationDTO storeDTO) {
        Store store = storeRepository.findStoreById(storeDTO.getStore_id());
        if(store == null) {
            throw new ApiException("Store not found");
        }
        Location newLocation = new Location(null, storeDTO.getArea(), storeDTO.getStreet(),store);
        locationRepository.save(newLocation);
    }

    public void updateLocationStore(StoreLocationDTO update_storeDTO) {
        Location location = locationRepository.findLocationById(update_storeDTO.getStore_id());
        if(location == null) {
            throw new ApiException("store has no location!");
        }
//        updateCD.setCustomer_id(customerDetails.getId());
        location.setArea(update_storeDTO.getArea());
        location.setStreet(update_storeDTO.getStreet());
        locationRepository.save(location);
    }

    public void deleteStoreLocation(Integer id) {
        Location location = locationRepository.findLocationById(id);
        if(location == null) {
            throw new ApiException("store has no location!");
        }
        locationRepository.delete(location);
    }
    // =============================== DTO - END =============================== //

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
