package com.flyright.flyright.controller;

import com.flyright.flyright.model.Aircraft;
import com.flyright.flyright.model.Flight;
import com.flyright.flyright.repository.AircraftRepository;
import com.flyright.flyright.repository.FlightRepository;
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
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private AircraftRepository aircraftRepository;

    @RequestMapping(value = "/flights/list", method = RequestMethod.GET)
    public String flights(Model model){
        model.addAttribute("flights", flightRepository.findAll());
        return "flight/list";
    }

    @RequestMapping(value = "/flights/availableFlights", method = RequestMethod.GET)
    public String availableFlights(Model model, @RequestParam String takeOffPoint, @RequestParam String destinationPoint){
        model.addAttribute("available_flights", flightRepository.findByTakeOffPointAndDestinationPointAndAvailableSeatsGreaterThan(takeOffPoint, destinationPoint, 0));
        return "flight/availableFlights";
    }

    @RequestMapping(value = "/flights/create/{id}", method = RequestMethod.GET)
    public String create(@PathVariable("id") int id,  Model model) {

        model.addAttribute("aircraft", aircraftRepository.findById(id).get());
        return "flight/create";
    }

    @RequestMapping(value = "/flights/add", method = RequestMethod.POST)
    public String add(Model model, @RequestParam int id, @RequestParam String flightNumber, @RequestParam String takeOffTime, @RequestParam String landingTime, @RequestParam String takeOffPoint, @RequestParam String destinationPoint, @RequestParam double price, @RequestParam int availableSeats) throws ParseException {

        Aircraft aircraft = aircraftRepository.findById(id).get();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        java.util.Date utilDate = formatter.parse(takeOffTime);
        Date takeOff_Time = new Date(utilDate.getTime());

        java.util.Date utilDate2 = formatter.parse(landingTime);
        Date landing_Time = new Date(utilDate2.getTime());

        Flight flight = new Flight(flightNumber, aircraft, takeOff_Time, landing_Time, takeOffPoint, destinationPoint, price, availableSeats);
        flightRepository.save(flight);
        return "redirect:/flights/list";
    }

    @RequestMapping(value = "/flights/edit/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") int id, Model model) {

        model.addAttribute("flight", flightRepository.findById(id).get());
        return "flight/edit";
    }

    @RequestMapping(value = "/flights/update", method = RequestMethod.POST)
    public String updateFlight(Model model, @RequestParam int id, @RequestParam String flightNumber, @RequestParam String takeOffTime, @RequestParam String landingTime, @RequestParam String takeOffPoint, @RequestParam String destinationPoint, @RequestParam double price, @RequestParam int availableSeats) throws ParseException {

        Flight flight= flightRepository.findById(id).get();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        java.util.Date utilDate = formatter.parse(takeOffTime);
        Date takeOff_Time = new Date(utilDate.getTime());
        flight.setTakeOffTime(takeOff_Time);

        java.util.Date utilDate2 = formatter.parse(landingTime);
        Date landing_Time = new Date(utilDate2.getTime());
        flight.setLandingTime(landing_Time);

        flight.setAvailableSeats(availableSeats);
        flight.setDestinationPoint(destinationPoint);
        flight.setFlightNumber(flightNumber);
        flight.setPrice(price);
        flight.setTakeOffPoint(takeOffPoint);

        flightRepository.save(flight);

        return "redirect:/flights/list";
    }

    @RequestMapping(value = "/flights/delete/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") int id, Model model) {

        Flight flight = flightRepository.findById(id).get();

        flightRepository.delete(flight);
        return "redirect:/flights/list";
    }
}
