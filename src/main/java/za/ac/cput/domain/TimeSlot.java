package za.ac.cput.domain;
import java.time.LocalTime;
public class TimeSlot {

        private String timeSlotId;
        private LocalTime startTime;
        private LocalTime endTime;

        private TimeSlot(Builder builder) {
            this.timeSlotId = builder.timeSlotId;
            this.startTime = builder.startTime;
            this.endTime = builder.endTime;
        }
        public String getTimeSlotId() {
            return timeSlotId;
        }
        public LocalTime getStartTime() {
            return startTime;
        }
        public LocalTime getEndTime() {
            return endTime;
        }

        public static class Builder {

            private String timeSlotId;
            private LocalTime startTime;
            private LocalTime endTime;

            public Builder setTimeSlotId(String timeSlotId) {
                this.timeSlotId = timeSlotId;
                return this;
            }

            public Builder setStartTime(LocalTime startTime) {
                this.startTime = startTime;
                return this;
            }

            public Builder setEndTime(LocalTime endTime) {
                this.endTime = endTime;
                return this;
            }

            public TimeSlot build() {

                return new TimeSlot(this);
            }
        }
    }

