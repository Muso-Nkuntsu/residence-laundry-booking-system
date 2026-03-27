package za.ac.cput.factory;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.LaundryMachine;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.TimeSlot;

import java.time.LocalDate;

public class BookingFactory {

    //I added other attributes to the Booking factory create: added TimeSlot class, LaundryMachine, Student
    public static Booking createBooking(String bookingID, LocalDate bookingDate,
                                        String bookingStatus,
                                        Student student,
                                        LaundryMachine machine,
                                        TimeSlot timeSlot){
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
                .setStudent(student)
                .setLaundryMachine(machine)
                .setTimeSlot(timeSlot)
                .build();
    }
}
