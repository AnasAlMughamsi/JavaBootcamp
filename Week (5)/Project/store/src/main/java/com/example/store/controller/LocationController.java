package com.example.store.controller;

import com.example.store.model.Location;
import com.example.store.service.LocationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @GetMapping("/get")
    public ResponseEntity getLocations() {
        List<Location> locations = locationService.getLocation();
        return ResponseEntity.status(200).body(locations);
    }

    @PostMapping("/add")
    public ResponseEntity addLocation(@Valid @RequestBody Location location) {
        locationService.addLocation(location);
        return ResponseEntity.status(200).body("Location added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateLocation(@PathVariable Integer id, @Valid @RequestBody Location updateLocation) {
        locationService.updateLocation(id, updateLocation);
        return ResponseEntity.status(200).body("Location updated!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLocations(@PathVariable Integer id) {
        locationService.deleteLocation(id);
        return ResponseEntity.status(200).body("Location deleted!!");
    }
}
