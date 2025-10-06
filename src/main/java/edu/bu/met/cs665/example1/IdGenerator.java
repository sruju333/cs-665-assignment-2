/**
 * Name: SRUJANA NIRANJANKUMAR
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/06/2025
 * File Name: IdGenerator.java
 * Description: This file defines the class members and operations for IdGenerator class
 */
package edu.bu.met.cs665.example1;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * This is IdGenerator class
 */
public final class IdGenerator {
    private static final AtomicInteger SEQ = new AtomicInteger(0);

    // Singleton pattern - private constructor to restrict object creation from outside
    private IdGenerator() {}

    /**
     * Increments the Atomic thread variable
     * @return int incremented number
    */
    public static int nextId() {
        return SEQ.incrementAndGet();
    }
}
