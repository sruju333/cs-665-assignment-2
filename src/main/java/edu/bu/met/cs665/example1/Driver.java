/**
 * Name: SRUJANA NIRANJANKUMAR
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/06/2025
 * File Name: Driver.java
 * Description: This file defines the class members and operations for Driver class
 */
package edu.bu.met.cs665.example1;

/**
 * This is Driver Class (Observables or Subscriber)
 */
public class Driver {

    private final String name;
    private final String vehicleType;

    // Parameterized Constructor (setters) and getters below
    public Driver(String name, String vehicleType) {
        this.name = name;
        this.vehicleType = vehicleType;
    }

    public String getName() {
        return name;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    /**
    * Called by NotificationService when a new request is broadcast.
     * @param request contains delivery request details
    */
    public void notify(DeliveryRequest request) {
        // Simple console output
        System.out.println(MessageFormatter.forDriver(this, request));
    }

}
