package za.ac.cput.factory;

import za.ac.cput.domain.Booking;

import java.time.LocalDate;

public class BookingFactory {

    public static Booking createBooking(String bookingID, LocalDate bookingDate, String bookingStatus){
        if(bookingID == null || bookingID.isEmpty()){
            throw new IllegalArgumentException("Booking ID cannot be null or empty");
        }
        if(bookingDate == null){
            throw new IllegalArgumentException("Booking date cannot be null");
        }
        if(bookingStatus == null || bookingStatus.isEmpty()){
            throw new IllegalArgumentException("Booking status cannot be null or empty");
        }
        return new Booking.Builder()
                .setBookingID(bookingID)
                .setBookingDate(bookingDate)
                .setBookingStatus(bookingStatus)
                .build();
    }
}
