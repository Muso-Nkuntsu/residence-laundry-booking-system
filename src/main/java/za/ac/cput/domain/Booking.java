package za.ac.cput.domain;

import java.time.LocalDate;


public class Booking {

        private String bookingID;
        private LocalDate bookingDate;
        private String bookingStatus;

        private Student student;
        private LaundryMachine laundryMachine;
        private TimeSlot timeSlot;

        private Booking(Builder builder) {
            this.bookingID = builder.bookingID;
            this.bookingDate = builder.bookingDate;
            this.bookingStatus = builder.bookingStatus;
            this.student = builder.student;
            this.laundryMachine = builder.laundryMachine;
            this.timeSlot = builder.timeSlot;
        }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID='" + bookingID + '\'' +
                ", bookingDate=" + bookingDate +
                ", bookingStatus='" + bookingStatus + '\'' +
                '}';
    }

    public String getBookingID() {

            return bookingID;
    }

    public String getBookingStatus() {

            return bookingStatus;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public Student getStudent() {
        return student;
    }

    public LaundryMachine getLaundryMachine() {
        return laundryMachine;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public static class Builder {

            private String bookingID;
            private LocalDate bookingDate;
            private String bookingStatus;
            private Student student;
            private LaundryMachine laundryMachine;
            private TimeSlot timeSlot;


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

        public Builder setStudent(Student student) {
            this.student = student;
            return this;
        }

        public Builder setLaundryMachine(LaundryMachine laundryMachine) {
            this.laundryMachine = laundryMachine;
            return this;
        }

        public Builder setTimeSlot(TimeSlot timeSlot) {
            this.timeSlot = timeSlot;
            return this;
        }
        public Builder copy(Booking booking) {
            this.bookingID = booking.bookingID;
            this.bookingDate = booking.bookingDate;
            this.bookingStatus = booking.bookingStatus;
            this.student = booking.student;
            this.laundryMachine = booking.laundryMachine;
            this.timeSlot = booking.timeSlot;
            return this;
        }


        public Booking build() {
                return new Booking(this);
            }
        }
    }

