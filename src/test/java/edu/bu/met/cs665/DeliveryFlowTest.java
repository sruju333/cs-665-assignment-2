/**
 * Name: SRUJANA NIRANJANKUMAR
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/06/2025
 * File Name: DeliveryFlowTest.java
 * Description: This file defines the test cases for DeliveryFlowTest class to verify implementation
 */
package edu.bu.met.cs665;

import edu.bu.met.cs665.example1.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is DeliveryFlowTest class
 */
class DeliveryFlowTest {

    @Test
    void broadcastsToAllFiveDrivers() {
        NotificationService notifier = new NotificationService();
        Shop shop = new Shop("Boston Grocery", notifier);

        shop.addDriver(new Driver("Abigail", "Van"));
        shop.addDriver(new Driver("Brendon", "Taxi"));
        shop.addDriver(new Driver("Chiara", "Scooter"));
        shop.addDriver(new Driver("Diego", "Taxi"));
        shop.addDriver(new Driver("Elise", "Van"));

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        PrintStream prev = System.out;
        System.setOut(new PrintStream(bout));
        try {
            shop.createAndBroadcast(
                    "Deliver package to Beacon St.",
                    new Location(42.355, -71.071, "Beacon St."),
                    Priority.NORMAL
            );
        } finally {
            System.setOut(prev);
        }

        String out = bout.toString();
        assertTrue(out.contains("Driver Abigail notified"));
        assertTrue(out.contains("Driver Brendon notified"));
        assertTrue(out.contains("Driver Chiara notified"));
        assertTrue(out.contains("Driver Diego notified"));
        assertTrue(out.contains("Driver Elise notified"));
    }

    @Test
    void addingDrivers_increasesDriverCount() {
        NotificationService notifier = new NotificationService();
        Shop shop = new Shop("Boston Grocery", notifier);

        assertEquals(0, shop.getDrivers().size(), "Shop should start with no drivers");

        shop.addDriver(new Driver("Abigail", "Van"));
        shop.addDriver(new Driver("Brendon", "Taxi"));
        shop.addDriver(new Driver("Chiara", "Scooter"));

        assertEquals(3, shop.getDrivers().size(), "Three drivers should now be registered");
    }

    @Test
    void addingSameDriverTwice_doesNotDuplicateNotification() {
        NotificationService notifier = new NotificationService();
        Shop shop = new Shop("Boston Grocery", notifier);
        Driver abigail = new Driver("Abigail", "Van");
        shop.addDriver(abigail);
        shop.addDriver(abigail); // Duplicate add attempt

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        PrintStream prev = System.out;
        System.setOut(new PrintStream(bout));
        try {
            shop.createAndBroadcast(
                    "Deliver milk to Boylston St.",
                    new Location(42.35, -71.08, "Boylston St."),
                    Priority.NORMAL
            );
        } finally {
            System.setOut(prev);
        }

        String out = bout.toString();
        int count = out.split("Driver Abigail notified", -1).length - 1;
        assertEquals(1, count, "Abigail should be notified only once");
    }

    @Test
    void noDrivers_noNotifications() {
        NotificationService notifier = new NotificationService();
        Shop shop = new Shop("Empty Shop", notifier);

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        PrintStream prev = System.out;
        System.setOut(new PrintStream(bout));
        try {
            shop.createAndBroadcast(
                    "Deliver to Commonwealth Ave.",
                    new Location(42.36, -71.12, "Commonwealth Ave."),
                    Priority.NORMAL
            );
        } finally {
            System.setOut(prev);
        }

        String out = bout.toString().trim();
        assertTrue(out.isEmpty(), "Expected no output when there are no drivers");
    }

    @Test
    void differentPriorities_displayedCorrectly() {
        NotificationService notifier = new NotificationService();
        Shop shop = new Shop("Boston Grocery", notifier);
        shop.addDriver(new Driver("Brendon", "Taxi"));

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        PrintStream prev = System.out;
        System.setOut(new PrintStream(bout));
        try {
            shop.createAndBroadcast(
                    "Deliver urgent meds to Hospital Rd.",
                    new Location(42.37, -71.09, "Hospital Rd."),
                    Priority.URGENT
            );
        } finally {
            System.setOut(prev);
        }

        String out = bout.toString();
        assertTrue(out.contains("[URGENT]"), "Output should show URGENT priority");
    }
}
