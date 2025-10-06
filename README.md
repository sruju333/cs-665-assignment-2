| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | SRUJANA NIRANJANKUMAR      |
| Date         | 10/06/2025                 |
| Course       | Fall                       |
| Assignment # | 2                          |

# Assignment Overview
In this assignment, I developed a **Delivery Notification System** that simulates a network of local shops and freelance drivers.  
When a shop receives a new delivery order, it creates a **Delivery Request**, which is **broadcast to all available drivers** (vans, taxis, scooters, etc.).  
Each driver is notified automatically about the request.

The goal of this project was to apply an appropriate **Software Design Pattern** (in this case, the **Observer Pattern**) to build a modular, flexible, and maintainable system.  
A simple command-line interface (CLI) is provided for demonstration; functionality is also verified using **JUnit tests**.

# GitHub Repository Link:
https://github.com/sruju333/cs-665-assignment-2

# Implementation Description 

### Flexibility
The implementation is highly extensible.  
New driver types (e.g., `BikeDriver`, `DroneDriver`) or shop variations can be added without modifying existing classes.  
Because the **Observer Pattern** decouples the `Shop` (publisher) from the `Driver` (subscriber), the system is open for extension but closed for modification—satisfying the **Open/Closed Principle**.

---

### Simplicity and Understandability
The design is straightforward and easy to follow:
- `Shop` manages a list of drivers and notifies them when a delivery request is created.
- `Driver` objects receive updates through a simple `notify()` method.
- Helper classes like `NotificationService` and `MessageFormatter` isolate responsibilities, enhancing clarity and reducing complexity.

This modular structure makes it easy for other developers to maintain or extend the system.

---

### Avoiding Duplicated Code
Shared behaviors—such as generating IDs, formatting output, and broadcasting messages—are centralized in helper classes (`IdGenerator`, `MessageFormatter`, and `NotificationService`).  
This eliminates redundancy, reduces maintenance overhead, and ensures consistent behavior across the system.

---

### Design Pattern Used
The **Observer Pattern** was used because it perfectly fits the publish-subscribe model of this delivery system.
- **Subject (Shop):** Generates and broadcasts delivery events.
- **Observers (Drivers):** Automatically receive updates about new requests.

This design promotes **low coupling**, **high cohesion**, and **reusability**, aligning with best practices in object-oriented software design.


# Maven Commands

## Compile
Type on the command line: 

```bash
mvn clean compile
```

## JUnit Tests

To run, use the following command:
```bash
mvn clean test
```


## Spotbugs

Use the following command:

```bash
mvn spotbugs:gui 
```

## Checkstyle

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`




