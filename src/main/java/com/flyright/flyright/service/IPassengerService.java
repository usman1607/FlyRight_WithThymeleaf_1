package com.flyright.flyright.service;

import com.flyright.flyright.exceptions.AgeLimitException;
import com.flyright.flyright.model.Passenger;

public interface IPassengerService {

    public boolean addPassenger(Passenger passenger) throws AgeLimitException;
}
