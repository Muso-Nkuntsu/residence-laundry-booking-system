package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.domain.Booking;

import java.time.LocalDate;

 class BookingFactoryTest {

     @Test
     @DisplayName("Test Booking format")
     void testCreateBooking(){
         Booking booking = BookingFactory.createBooking("Talent",
        LocalDate.now(), "Confirmed");

         assertNotNull(booking);
         assertEquals("Talent", booking.getBookingID());
         assertEquals("Confirmed", booking.getBookingStatus());
     }
     @Test
     void testCreateBookingWithNullID(){
         Booking booking = BookingFactory.createBooking(null,
                 LocalDate.now(),
                 "Confirmed");

         assertNull(booking);
     }
     @Test
     void testCreateBookingWithEmptyStatus(){
         Booking booking = BookingFactory.createBooking("Talent",
                 LocalDate.now(),
                 "");

         assertNull(booking);
     }
}
