package com.example.store.service;

import com.example.store.api.ApiException;
import com.example.store.model.Location;
import com.example.store.model.Location;
import com.example.store.repository.LocationRepository;
import com.example.store.repository.LocationRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;
    public List<Location> getLocation() {
        return locationRepository.findAll();
    }

    public void addLocation(Location location) {
        locationRepository.save(location);
    }

    public void updateLocation(Integer id, Location updateLocation) {
        Location location = locationRepository.findLocationById(id);
        if(location == null) {
            throw new ApiException("Location not found");
        }
        updateLocation.setId(id);
        locationRepository.save(updateLocation);
    }


    public void deleteLocation(Integer id) {
        Location location = locationRepository.findLocationById(id);
        if(location == null) {
            throw new ApiException("Location not found");
        }
        locationRepository.delete(location);
    }
}
