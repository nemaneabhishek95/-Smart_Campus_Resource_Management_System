# Smart Campus Resource Management System

A Java console application for managing campus students, resources, and bookings. It demonstrates object-oriented programming, collections, exception handling, and multithreading.

## Features

- Add, view, search, and alphabetically sort students
- Add and view campus resources
- Book a resource for an existing student
- Prevent duplicate bookings of the same resource
- Show totals for students, resources, bookings, available resources, and booked resources
- Simulate two students concurrently attempting to reserve one resource
- Validate blank input, duplicate IDs, and invalid student/resource IDs

## Requirements

- Java Development Kit (JDK) 8 or later
- A terminal, Command Prompt, PowerShell, VS Code, IntelliJ IDEA, or Eclipse

No external libraries are required.

## How to Run

1. Open a terminal in the folder that contains `SmartCampusSystem.java`.
2. Compile the program:

   ```powershell
   javac SmartCampusSystem.java
   ```

3. Run it:

   ```powershell
   java SmartCampusSystem
   ```

4. Choose an option from the on-screen menu.

## Recommended Demo for Evaluation

1. Choose `2` to show the two sample students.
2. Choose `5` to show the two sample resources.
3. Choose `6` and book `R101` for `S001`, using a purpose such as `AI workshop`.
4. Choose `6` again and try booking `R101` for `S002`. The program rejects the duplicate booking.
5. Choose `8` to show the analytics.
6. Choose `9` to run the multithreading demonstration. Two threads request the same lab; only one succeeds because booking is synchronized.

## Java Concepts Used

| Concept | Where it is used |
| --- | --- |
| Encapsulation | `Student`, `CampusResource`, and `Booking` model classes |
| Collections | `HashMap` stores students/resources; `ArrayList` stores bookings |
| Exception handling | Invalid choices and invalid booking data are handled cleanly |
| Generics | Type-safe `Map` and `List` collections |
| Multithreading | `BookingAttempt` implements `Runnable` and uses `Thread` |
| Synchronization | The `reserve` method prevents a race condition/double booking |
| Sorting | Students are displayed alphabetically by name |

## Project Files

```text
SmartCampusSystem.java  Main application source code
README.md               Setup, features, and demonstration guide
```

## Viva / Presentation Summary

This project solves a campus resource-allocation problem. Students and resources are stored in collections for fast lookup. A booking changes a resource from available to booked. The synchronized booking method is important because, when two students request the same resource at once, it ensures that only one booking can be recorded.
