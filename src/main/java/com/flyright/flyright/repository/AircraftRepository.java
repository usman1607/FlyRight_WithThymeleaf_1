package com.flyright.flyright.repository;

import com.flyright.flyright.model.Aircraft;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AircraftRepository extends CrudRepository<Aircraft, Integer> {
    Aircraft findAircraftByRegistrationNumber(String registrationNumber);
    List<Aircraft> findAircraftByCapacityGreaterThanEqual(int capacity);
}
