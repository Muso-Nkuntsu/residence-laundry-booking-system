package za.ac.cput.factory;

import za.ac.cput.domain.Booking;

import java.time.LocalDate;

public class BookingFactory {

    public static Booking createBooking(String bookingID, LocalDate bookingDate, String bookingStatus){
        if(bookingID == null || bookingID.isEmpty()){
            return null;
        }
        if(bookingDate == null){
            return null;
        }
        if(bookingStatus == null || bookingStatus.isEmpty()){
            return null;
        }
        return new Booking.Builder()
                .setBookingID(bookingID)
                .setBookingDate(bookingDate)
                .setBookingStatus(bookingStatus)
                .build();
    }
}
