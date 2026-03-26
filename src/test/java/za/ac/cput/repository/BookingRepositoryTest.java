package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.LaundryMachine;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.TimeSlot;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookingRepositoryTest {
     private static BookingRepository repository = BookingRepository.getRepository();

    //Using Builder pattern instead of constructor (since constructor is private)
    private static Student student = new Student.Builder()
            .setStudentId("1")
            .setName("Talent")
            .setSurname("Nocuze")
            .setEmail("talent@gmail.com")
            .build();

    //Using Builder pattern instead of non-existing constructor
    private static LaundryMachine laundryMachine = new LaundryMachine.Builder()
            .setMachineId("M1")
            .setMachineNumber(1)
            .setStatus("Available")
            .build();

    //Replaced String time with LocalTime
    private static TimeSlot timeSlot = new TimeSlot.Builder()
            .setTimeSlotId("T1")
            .setStartTime(LocalTime.of(8, 0))
            .setEndTime(LocalTime.of(9, 0))
            .build();

    // Booking object linking all entities (Student, Machine, TimeSlot)
     private static Booking booking = new Booking.Builder()
             .setBookingID("B001")
             .setBookingDate(LocalDate.now())
             .setBookingStatus("Confirmed")
             .setStudent(student) //link Student
             .setLaundryMachine(laundryMachine) //link LaundryMachine
             .setTimeSlot(timeSlot)  //Link TimeSlot
             .build();

     @Test
    @Order(1)
    void create(){
         Booking created = repository.create(booking);
         assertNotNull(created);
         assertEquals("B001", created.getBookingID());
     }
     @Test
    @Order(2)
    void read(){
         Booking read = repository.read("B001");
         assertNotNull(read);
         assertEquals("B001", read.getBookingID());
     }
     @Test
    @Order(3)
    void update(){
         Booking updatedBooking = new Booking.Builder()
                 .copy(booking)
                 .setBookingStatus("Completed")
                 .build();

         Booking updated = repository.update(updatedBooking);
         assertNotNull(updated);
         assertEquals("Completed", updated.getBookingStatus());
     }
    @Test
    @Order(4)
    void getAll() {
        assertFalse(repository.getAll().isEmpty());
    }
    @Test
    @Order(5)
    void delete() {
        boolean deleted = repository.delete("B001");
        assertTrue(deleted);
    }

}
