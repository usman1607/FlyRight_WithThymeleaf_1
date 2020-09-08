package com.flyright.flyright.service;

import com.flyright.flyright.exceptions.AgeLimitException;
import com.flyright.flyright.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flyright.flyright.repository.PassengerRepository;

@Service
public class PassengerService implements IPassengerService {
    @Autowired
    private PassengerRepository passengerRepository;
    @Override
    public boolean addPassenger(Passenger passenger) throws AgeLimitException {
        if(passenger.getAge()<18){
            throw new AgeLimitException(String.format("Age must be above 18. Passenger %s is %d years old.", passenger.getLastName(), passenger.getAge()));
        }
        passengerRepository.save(passenger);
        return true;
    }
}
