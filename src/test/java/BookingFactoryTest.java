import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.domain.Booking;
import za.ac.cput.factory.BookingFactory;
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
     void testCreateBookingWithNullID() {
         Exception exception = assertThrows(IllegalArgumentException.class, () -> {
             Booking booking = BookingFactory.createBooking(null,
                     LocalDate.now(),
                     "Confirmed");

         });
         assertEquals("Booking ID cannot be null or empty", exception.getMessage());
     }
     @Test
     void testCreateBookingWithEmptyStatus(){
         Exception exception = assertThrows(IllegalArgumentException.class, () -> {
             Booking booking = BookingFactory.createBooking("Talent",
                     LocalDate.now(),
                     "");

         });   assertEquals("Booking status cannot be null or empty", exception.getMessage());
     }
}
