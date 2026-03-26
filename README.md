This project implements the Booking Repository for a Laundry Booking System. The Booking entity acts as a central link between:
Student
Laundry Machine
Time Slot
The repository manages all booking records using in-memory storage and follows best practices such as the Singleton Design Pattern and Builder Pattern.

Each Booking is linked to:
A valid Student
A valid LaundryMachine
A valid TimeSlot
This ensures data consistency and prevents invalid bookings.

Features:
Create, Read, Update, Delete (CRUD) operations

Design Patterns:
Builder Pattern → Used to construct domain objects
Singleton Pattern → Ensures one instance of the repository
Repository Pattern → Separates data access logic
