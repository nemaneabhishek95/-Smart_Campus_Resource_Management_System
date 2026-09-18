# Problem Statement

Campus facilities such as seminar halls, laboratories, and shared equipment are often booked informally. This can lead to duplicate reservations, uncertainty about availability, and difficulty tracking overall resource usage. The Smart Campus Resource Management System provides a simple console-based solution for organizing these records.

## Scope

The system stores student details, manages campus resources, records a resource booking, shows booking/availability information, and produces basic analytics. It uses in-memory storage for the current session; database storage and authentication are outside this project scope.

## Target Users

- Campus administrators managing resources
- Student clubs and students requesting resources
- Faculty coordinators monitoring facility availability

## High-Level Features

1. Student management: add, list, search, and alphabetically sort students.
2. Resource management: add, list, and display availability of rooms, labs, and equipment.
3. Booking management: create and view resource bookings while preventing a duplicate reservation.
4. Analytics: display counts of students, resources, bookings, available resources, and booked resources.
5. Concurrent-booking simulation: demonstrate how synchronization avoids a race condition.

## Non-Functional Requirements

- **Usability:** a numbered menu and clear messages make the program easy for first-time users.
- **Reliability:** validation rejects empty values, duplicate IDs, and bookings for unavailable resources.
- **Performance:** hash-map lookup provides fast student and resource retrieval for the project scale.
- **Maintainability:** model, service, utility, and interface responsibilities are separated into classes.
- **Resource efficiency:** data is kept in memory, requiring no database or external library.
- **Concurrency safety:** the synchronized booking operation permits only one successful reservation for a shared resource.
