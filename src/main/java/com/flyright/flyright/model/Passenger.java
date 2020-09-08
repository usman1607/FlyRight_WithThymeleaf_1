package com.flyright.flyright.model;

import javax.persistence.*;

@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String lastName;
    private String firstName;
    private int age;
    private String email;
    private String phone;
    private String address;

    public Passenger() {

    }

    public Passenger(String lastName, String firstName, int age, String email, String phone, String address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
