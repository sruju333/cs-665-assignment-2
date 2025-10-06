/**
 * Name: SRUJANA NIRANJANKUMAR
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/06/2025
 * File Name: Shop.java
 * Description: This file defines the class members and operations for Shop class
 */
package edu.bu.met.cs665.example1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * This is a Shop class (Observable or Publisher)
 */
public class Shop {

    private final String name;
    private final List<Driver> drivers = new ArrayList<>();
    private final NotificationService notifier;

    // Parameterized constructor and getters below
    public Shop(String name, NotificationService notifier) {
        this.name = Objects.requireNonNull(name, "name");
        this.notifier = Objects.requireNonNull(notifier, "notifier");
    }

    public String getName() { return name; }

    /**
     * Ensures only unique, valid drivers are added to the shop’s driver list.
     * @param d contains driver details
     */
    public void addDriver(Driver d) {
        if (d != null && !drivers.contains(d)) drivers.add(d);
    }

    /**
     * Provides safe, read-only access to the current list of drivers.
     * @return unmodifiable list of drivers
     */
    public List<Driver> getDrivers() {
        return Collections.unmodifiableList(drivers);
    }

    /**
     * Creates a request and broadcasts it to all drivers
     * @param details deliver package to location street address
     * @param dropoff street address
     * @param priority URGENT or NORMAL enum
     * @return delivery request after notifying
     */
    public DeliveryRequest createAndBroadcast(String details, Location dropoff, Priority priority) {
        int id = IdGenerator.nextId();
        DeliveryRequest request = new DeliveryRequest(id, details, name, dropoff, priority);
        notifier.notifyAllDrivers(request, drivers);
        return request;
    }

}
