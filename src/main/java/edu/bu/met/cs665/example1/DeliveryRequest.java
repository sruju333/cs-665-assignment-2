/**
 * Name: SRUJANA NIRANJANKUMAR
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/06/2025
 * File Name: DeliveryRequest.java
 * Description: This file defines the class members and operations for DeliveryRequest class
 */
package edu.bu.met.cs665.example1;

/**
 * This is a DeliveryRequest class
 */
public final class DeliveryRequest {

    private final int id;
    private final String details;
    private final String shopName;
    private final Location dropoff;
    private final Priority priority;

    // Parameterized Constructor (setters) and getters below
    public DeliveryRequest(int id, String details, String shopName, Location dropoff, Priority priority) {
        this.id = id;
        this.details = details;
        this.shopName = shopName;
        this.dropoff = dropoff;
        this.priority = (priority != null) ? priority : Priority.NORMAL;
    }

    public int getId() {
        return id;
    }

    public String getDetails() {
        return details;
    }

    public String getShopName() {
        return shopName;
    }

    public Location getDropoff() {
        return dropoff;
    }

    public Priority getPriority() {
        return priority;
    }
}
