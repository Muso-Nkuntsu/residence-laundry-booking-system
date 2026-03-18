package za.ac.cput.domain;

import java.time.LocalDate;


public class Booking {

        private String bookingID;
        private LocalDate bookingDate;
        private String bookingStatus;

        private Booking(Builder builder) {
            this.bookingID = builder.bookingID;
            this.bookingDate = builder.bookingDate;
            this.bookingStatus = builder.bookingStatus;
        }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID='" + bookingID + '\'' +
                ", bookingDate=" + bookingDate +
                ", bookingStatus='" + bookingStatus + '\'' +
                '}';
    }

    public static class Builder {

            private String bookingID;
            private LocalDate bookingDate;
            private String bookingStatus;

            public Builder createBooking(String bookingID, LocalDate bookingDate, String bookingStatus){
                this.bookingID = bookingID;
                this.bookingDate = bookingDate;
                this.bookingStatus = bookingStatus;
                return this;
        }

            public Builder setBookingId(String bookingID) {
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

            public Booking build() {
                return new Booking(this);
            }
        }
    }

