package com.flyright.flyright;

import com.flyright.flyright.model.Aircraft;
import com.flyright.flyright.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlyrightApplication /*implements CommandLineRunner*/ {

    //@Autowired
    //private AircraftRepository aircraftRepository;
    public static void main(String[] args) {
        SpringApplication.run(FlyrightApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        if(aircraftRepository.findAircraftByRegistrationNumber("LA1007") == null){
//            Aircraft aircraft = new Aircraft("LA1007", "Emirate", "GREEN", 100);
//            aircraftRepository.save(aircraft);
//        }
//    }

}
