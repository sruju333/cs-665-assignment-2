/**
 * Name: SRUJANA NIRANJANKUMAR
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/06/2025
 * File Name: MessageFormatter.java
 * Description: This file defines the class members and operations for MessageFormatter class
 */
package edu.bu.met.cs665.example1;
/**
 * This is a Message Formatter class
 */
public final class MessageFormatter {

    // Singleton pattern - Empty constructor prevents object creation
    private MessageFormatter() {}

    /**
     *  This function formats the string response
     *
     * @param d contains driver details
     * @param r contains delivery request details
     * @return String with information about delivery request to driver
     */
    public static String forDriver(Driver d, DeliveryRequest r) {
        return "Driver " + d.getName() + " notified: Request #" + r.getId()
                + " from " + r.getShopName() + " [" + r.getPriority() + "]: "
                + r.getDetails() + " -> " + r.getDropoff().getLabel();
    }

}
