package com.flyright.flyright.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(unique = true, length = 50)
    private String flightNumber;

    @NotNull
    @ManyToOne
    private Aircraft aircraft;

    private Date takeOffTime;
    private Date landingTime;

    private String takeOffPoint;
    private String destinationPoint;
    private double price;
    private int availableSeats;

    public Flight() {

    }

    public Flight(String flightNumber, Aircraft aircraft, Date takeOffTime, Date landingTime, String takeOffPoint, String destinationPoint, double price, int availableSeats) {
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.takeOffTime = takeOffTime;
        this.landingTime = landingTime;
        this.takeOffPoint = takeOffPoint;
        this.destinationPoint = destinationPoint;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    public int getId() {
        return id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Date getTakeOffTime() {
        return takeOffTime;
    }

    public void setTakeOffTime(Date takeOffTime) {
        this.takeOffTime = takeOffTime;
    }

    public Date getLandingTime() {
        return landingTime;
    }

    public void setLandingTime(Date landingTime) {
        this.landingTime = landingTime;
    }

    public String getTakeOffPoint() {
        return takeOffPoint;
    }

    public void setTakeOffPoint(String takeOffPoint) {
        this.takeOffPoint = takeOffPoint;
    }

    public String getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(String destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
