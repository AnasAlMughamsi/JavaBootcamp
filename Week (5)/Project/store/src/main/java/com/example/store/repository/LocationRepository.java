package com.example.store.repository;

import com.example.store.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

    Location findLocationById(Integer id);
}
