package za.ac.cput.repository;
import za.ac.cput.domain.Booking;

import java.util.HashSet;
import java.util.Set;

public class BookingRepository implements iBookingRepository {

    private static BookingRepository repository = null;
    private Set<Booking> bookingDB;

    private BookingRepository() {
        bookingDB = new HashSet<>();
    }

    static BookingRepository getRepository() {
        if (repository == null) {
            repository = new BookingRepository();
        }
        return repository;
    }

    //Creating methods
    @Override
    public Booking create(Booking booking) {
        if (booking.getStudent() == null ||
                booking.getLaundryMachine() == null ||
                booking.getTimeSlot() == null) {
            return null;
        }
        bookingDB.add(booking);
        return booking;
    }
    //Reading methods
    @Override
    public Booking read(String BookingID) {
        return bookingDB.stream()
                .filter(booking -> booking.getBookingID().equals(BookingID))
                .findAny()
                .orElse(null);
    }
    //Updating methods
    @Override
    public Booking update(Booking booking) {
        Booking book = read(booking.getBookingID());
        if (book != null) {
            bookingDB.remove(book);
            bookingDB.add(booking);
            return booking;
        }
        return null;
    }
    //Deleting methods
    @Override
    public boolean delete(String BookingID) {
        Booking booking = read(BookingID);
        if (booking != null) {
            bookingDB.remove(booking);
            return true;
        }
        return false;
    }
    @Override
    public Set<Booking> getAll() {
        return bookingDB;
    }
}
