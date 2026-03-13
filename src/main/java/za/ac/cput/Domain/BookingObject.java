package za.ac.cput.Domain;

import java.time.LocalDate;

public class BookingObject {
    private String bookingID;
    private LocalDate bookingDate;
    private String bookingStatus;

    public BookingObject(Builder builder) {
        this.bookingID = builder.bookingID;
        this.bookingDate = builder.bookingDate;
        this.bookingStatus = builder.bookingStatus;

    }

    public void displayBookingObject() {
        //DONT USE SYSTEM OUT PRINTLN
    }

    public static class Builder {
        private String bookingID;
        private LocalDate bookingDate;
        private String bookingStatus;

        public Builder createStudent(String bookingID, LocalDate bookingDate, String bookingStatus) {
            this.bookingID = bookingID;
            this.bookingDate = bookingDate;
            this.bookingStatus = bookingStatus;
            return this;
        }

        public Builder setBookingID(String bookingID) {
            this.bookingID = bookingID;
            return this;
        }

        public Builder setBookingDate(LocalDate bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }

        public Builder setBookingStatus(String bookingStatus) {
            this.bookingStatus = bookingStatus;
            return this;
        }

        public  BookingObject build() {

            return new BookingObject(this);
        }
    }
}


