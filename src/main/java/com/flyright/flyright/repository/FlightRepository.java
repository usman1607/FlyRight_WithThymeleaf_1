package com.flyright.flyright.repository;

import com.flyright.flyright.model.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Integer> {
    Flight findFlightByFlightNumber(String flightNumber);
    List<Flight> findByTakeOffPointAndDestinationPointAndAvailableSeatsGreaterThan(String t, String d, int a);
}
