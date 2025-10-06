/**
 * Name: SRUJANA NIRANJANKUMAR
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/06/2025
 * File Name: NotificationService.java
 * Description: This file defines the class members and operations for NotificationService class
 */
package edu.bu.met.cs665.example1;

import java.util.List;
import java.util.Objects;
/**
 * This is a Notification Service class
 */
public class NotificationService {

    /**
     * This class method takes request details and driver list to notify them about request
     * @param request contains request details
     * @param drivers list of Object Driver
     */
    public void notifyAllDrivers(DeliveryRequest request, List<Driver> drivers) {
        Objects.requireNonNull(request, "request");
        Objects.requireNonNull(drivers, "drivers");
        for (Driver d : drivers) {
            d.notify(request);
        }
    }

}
