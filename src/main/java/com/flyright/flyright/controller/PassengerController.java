package com.flyright.flyright.controller;

import com.flyright.flyright.model.Flight;
import com.flyright.flyright.model.Passenger;
import com.flyright.flyright.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class PassengerController {

    @Autowired
    PassengerRepository passengerRepository;

    @RequestMapping(value = "/passengers/list", method = RequestMethod.GET)
    public String passengers(Model model){
        model.addAttribute("bookings", passengerRepository.findAll());
        return "passenger/list";
    }

    @RequestMapping(value = "/passengers/delete/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") int id, Model model) {

        Passenger passenger = passengerRepository.findById(id).get();

        passengerRepository.delete(passenger);
        return "redirect:/passengers/list";
    }

    @RequestMapping(value = "/passengers/edit/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") int id, Model model) {

        model.addAttribute("passenger", passengerRepository.findById(id).get());
        return "passenger/edit";
    }

    @RequestMapping(value = "/passengers/update", method = RequestMethod.POST)
    public String updateFlight(Model model, @RequestParam int id, @RequestParam String lastName, @RequestParam String firstName, @RequestParam int age, @RequestParam String email, @RequestParam String phone, @RequestParam String address) {

        Passenger passenger= passengerRepository.findById(id).get();

        passenger.setLastName(lastName);
        passenger.setFirstName(firstName);
        passenger.setAge(age);
        passenger.setEmail(email);
        passenger.setPhone(phone);
        passenger.setAddress(address);

        passengerRepository.save(passenger);

        return "redirect:/passengers/list";
    }
}
