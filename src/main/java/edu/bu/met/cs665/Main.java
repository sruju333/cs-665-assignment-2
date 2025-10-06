/**
 * Name: SRUJANA NIRANJANKUMAR
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/06/2025
 * File Name: Main.java
 * Description: This class provides a command-line interface (CLI) that showcases the publisher-subscriber
 * (observer) model, illustrating interactions between a shop and drivers responding to delivery requests.
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.example1.*;

import java.util.Scanner;

/**
 * This is the Main class.
 */
public class Main {

  /**
   * Tries to convert a string to a double.
   * Returns the given fallback value if the string is not a valid number.
   *
   * @param s the string to convert
   * @param fallback the value to return if conversion fails
   * @return the parsed double or the fallback value
   */
  private static double parseDoubleOr(String s, double fallback) {
    try {
      return Double.parseDouble(s);
    } catch (NumberFormatException e)
    {
      return fallback;
    }
  }

  /**
   * Runs the delivery request CLI demo.
   * Creates a shop, registers drivers, and lets the user enter delivery details
   * to simulate notifications being sent to drivers.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    NotificationService notifier = new NotificationService();
    Shop shop = new Shop("Boston Grocery", notifier);

    // Register 5 drivers
    shop.addDriver(new Driver("Abigail", "Van"));
    shop.addDriver(new Driver("Brendon", "Van"));
    shop.addDriver(new Driver("Chiara", "Taxi"));
    shop.addDriver(new Driver("Diego", "Scooter"));
    shop.addDriver(new Driver("Elise", "Scooter"));

    try (Scanner sc = new Scanner(System.in)) {
      System.out.println("=== Delivery Request CLI (type 'quit' to exit) ===");
      System.out.print("Describe the delivery (e.g., 'Deliver package to Beacon St.'): ");
      String details = sc.nextLine().trim();
      if (details.isEmpty()) {
        details = "Deliver package to Beacon St.";
      }

      System.out.print("Drop-off label (e.g., 'Beacon St.'): ");
      String label = sc.nextLine().trim();
      if (label.isEmpty()) {
        label = "Beacon St.";
      }

      System.out.print("Latitude (default 42.355): ");
      String latStr = sc.nextLine().trim();
      double lat = latStr.isEmpty() ? 42.355 : parseDoubleOr(latStr, 42.355);

      System.out.print("Longitude (default -71.071): ");
      String lonStr = sc.nextLine().trim();
      double lon = lonStr.isEmpty() ? -71.071 : parseDoubleOr(lonStr, -71.071);

      System.out.print("Priority [NORMAL|URGENT] (default NORMAL): ");
      String prStr = sc.nextLine().trim().toUpperCase();
      Priority pr = "URGENT".equals(prStr) ? Priority.URGENT : Priority.NORMAL;

      DeliveryRequest req = shop.createAndBroadcast(
              details,
              new Location(lat, lon, label),
              pr
      );

      System.out.println();
      System.out.println("Created " + req.getShopName() + " request #" + req.getId()
              + " (" + req.getPriority() + ") and notified "
              + shop.getDrivers().size() + " drivers.");
      System.out.println("=== Done ===\n");
    }
  }
}
