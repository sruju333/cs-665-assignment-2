/**
 * Name: SRUJANA NIRANJANKUMAR
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/06/2025
 * File Name: Location.java
 * Description: This file defines the class members and operations for Location class
 */
package edu.bu.met.cs665.example1;

/**
 * This is Location class
 */
public final class Location {

    private final double lat;
    private final double lon;
    private final String label;

    // Parameterized Constructor (setters) and getters below
    public Location(double lat, double lon, String label) {
        this.lat = lat;
        this.lon = lon;
        this.label = label;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getLabel() {
        return label;
    }
}
