package com.flyright.flyright.controller;

import com.flyright.flyright.model.Aircraft;
import com.flyright.flyright.repository.AircraftRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AircraftController {
    @Autowired
    private AircraftRepository aircraftRepository;

    @RequestMapping(value = "/aircrafts/list", method = RequestMethod.GET)
    public String aircrafts(Model model){
        model.addAttribute("aircrafts", aircraftRepository.findAll());
//        model.addAttribute("message", "Thank you for flying with us...");
        return "aircraft/list";
    }

    @RequestMapping(value = "/aircrafts/create", method = RequestMethod.GET)
    public String create(Model model) {
        return "aircraft/create";
    }

    @RequestMapping(value = "/aircrafts/add", method = RequestMethod.POST)
    public String add(Model model, @RequestParam String registrationNumber,@RequestParam String name, @RequestParam String type, @RequestParam int capacity) {

        Aircraft aircraft = new Aircraft(registrationNumber, name, type, capacity);
        aircraftRepository.save(aircraft);
        return "redirect:/aircrafts/list";
    }

    @RequestMapping(value = "/aircrafts/edit/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        //Aircraft aircraft = aircraftRepository.findById(id);

        model.addAttribute("aircraft", aircraftRepository.findById(id).get());
        return "aircraft/edit";
    }

    @RequestMapping(value = "/aircrafts/update", method = RequestMethod.POST)
    public String updateAircraft(Model model, @RequestParam int id, @RequestParam String registrationNumber,@RequestParam String name, @RequestParam String type, @RequestParam int capacity) {

        Aircraft aircraft= aircraftRepository.findById(id).get();
        aircraft.setRegistrationNumber(registrationNumber);
        aircraft.setName(name);
        aircraft.setType(type);
        aircraft.setCapacity(capacity);
        aircraftRepository.save(aircraft);

        return "redirect:/aircrafts/list";
    }

    @RequestMapping(value = "/aircrafts/delete/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") int id, Model model) {

        Aircraft aircraft = aircraftRepository.findById(id).get();

        aircraftRepository.delete(aircraft);
        return "redirect:/aircrafts/list";
    }
}
