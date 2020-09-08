package com.flyright.flyright.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.swing.*;
import java.io.Serializable;

@Entity
public class Aircraft implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(unique = true, length = 50)
    private String registrationNumber;
    private String name;
    private String type;
    int capacity;

    public Aircraft() {

    }

    public Aircraft(String registrationNumber, String name, String type, int capacity) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
