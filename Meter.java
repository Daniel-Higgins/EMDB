package csc241hw07;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Danny
 */
public abstract class Meter {
private String id;
    private ArrayList<MeterReading> readings;
    private String brand;
    private String type;
    private String location;
    private Address address;

//The following methods should be available:
// - getID() - Returns a String showing a unique identification number
    public String getID() {
        return id;
    }

// - getReadings() - Returns an array of MeterReadings (see below) of all readings
    public MeterReading[] getReadings() {

        MeterReading[] readingsArray = new MeterReading[readings.size()];
        readingsArray = readings.toArray(readingsArray);
        return readingsArray;
    }

// - getCurrentReading() - Returns a reference to the most recent MeterReading
    public MeterReading getCurrentReading() {
        MeterReading mr;
        if (readings.isEmpty()) {
            mr = null;
        } else {
            // get the last reading
            mr = readings.get(readings.size() - 1);
        }
        return mr;
    }

// - addReading(MeterReading m) - Adds a new MeterReading to the meter
    public void addReading(MeterReading m) {
       readings.add(m);
    }

// - getBrand() - Return a String indicating the manufacturer
    public String getBrand() {
        return brand;
    }
// - getType() - Returns a String indicating if the meter can send using internal clock (push vs. polling)

    public abstract String getType();

// - getLocation() - Returns a String with location notes

    public String getLocation() {
        return location;
    }
// - getAddress() - Returns a reference to an Address where this meter is located

    public Address getAddress() {
        return address;
    }
// - setLocation(Address a, String n) - Sets the address and location notes for this meter

    public void setLocation(Address a, String n) {
        address = a;
        location = n;
    }
// - A constructor to initialize ID, brand, and type.

    public Meter(String i, String b, String t) {
        id = i;
        brand = b;
        type = t;
        address = null;
        location = "";

        // Initialize the array size to 50 readings
        readings = new ArrayList<MeterReading>();
    }
}

