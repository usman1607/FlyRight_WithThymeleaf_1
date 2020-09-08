package com.flyright.flyright.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true, length = 50)
    private String bookingNumber;
    @ManyToOne
    private Flight flight;
    @ManyToOne
    private Passenger passenger;
    private Date bookingDate;
    private int seatNo;

    public Booking() {

    }

    public Booking(String bookingNumber, Flight flight, Passenger passenger, Date bookingDate, int seatNo) {
        this.bookingNumber = bookingNumber;
        this.flight = flight;
        this.passenger = passenger;
        this.bookingDate = bookingDate;
        this.seatNo = seatNo;
    }

    public int getId() {
        return id;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }
}
