package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.TimeSlot;
import za.ac.cput.domain.LaundryMachine;
import za.ac.cput.domain.MachineStatus;

import java.time.*;

class BookingFactoryTest {

     //I changed tests cases as well
     @Test
     @DisplayName("Test Booking format")
     void testCreateBooking(){
                Student student = new Student.Builder()
                        .setStudentId("231223722")
                        .setName("Talent")
                        .setSurname("Nocuze")
                        .setEmail("talentnocuze@gmail.com")
                        .build();

         LaundryMachine machine = new LaundryMachine.Builder()
                 .setMachineId("LM001")
                 .setMachineNumber(1)
                 .setStatus(MachineStatus.AVAILABLE.name())
                 .build();

         TimeSlot timeSlot = new TimeSlot.Builder()
                 .setStartTime(LocalTime.of(10, 0))
                 .setEndTime(LocalTime.of(11, 0))
                 .build();

         Booking booking = BookingFactory.createBooking(
                 "B234",
                 LocalDate.now(),
                 "Confirmed",
                 student,
                 machine,
                 timeSlot
         );
         assertNotNull(booking);
         assertEquals("B234", booking.getBookingID());
         assertEquals("Confirmed", booking.getBookingStatus());
     }
     @Test
     void testCreateBookingWithNullID() {
         Student student = new Student.Builder().setStudentId("1").build();
         LaundryMachine machine = new LaundryMachine.Builder().setMachineId("LM1").build();
         TimeSlot timeSlot = new TimeSlot.Builder()
                 .setStartTime(LocalTime.of(10,0))
                 .setEndTime(LocalTime.of(11,0))
                 .build();
         Exception exception = assertThrows(IllegalArgumentException.class, () -> {
             BookingFactory.createBooking(null, LocalDate.now(), "Confirmed", student, machine, timeSlot);
         });
         assertEquals("Booking ID cannot be null or empty", exception.getMessage());
     }
     @Test
     void testCreateBookingWithEmptyStatus(){
         Student student = new Student.Builder().setStudentId("1").build();
         LaundryMachine machine = new LaundryMachine.Builder().setMachineId("LM1").build();
         TimeSlot timeSlot = new TimeSlot.Builder()
                 .setStartTime(LocalTime.of(10,0))
                 .setEndTime(LocalTime.of(11,0))
                 .build();
         Exception exception = assertThrows(IllegalArgumentException.class, () -> {
             BookingFactory.createBooking("B002", LocalDate.now(), "", student, machine, timeSlot);
         });

         assertEquals("Booking status cannot be null or empty", exception.getMessage());

     }
}
