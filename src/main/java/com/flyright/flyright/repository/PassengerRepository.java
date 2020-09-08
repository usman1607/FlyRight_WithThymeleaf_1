package com.flyright.flyright.repository;

import com.flyright.flyright.model.Aircraft;
import com.flyright.flyright.model.Passenger;
import org.springframework.data.repository.CrudRepository;

public interface PassengerRepository extends CrudRepository<Passenger, Integer>  {
    Passenger findPassengerByLastNameAndFirstNameAndEmail(String lastName, String firstName, String email);
}
