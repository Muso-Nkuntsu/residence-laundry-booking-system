package za.ac.cput.domain;

import java.util.Set;

public class LaundryRoom {

    private String roomId;
    private String location;
    private int floorNumber;
    private Set<LaundryMachine>laundryMachines;


    private LaundryRoom(Builder builder) {
        this.roomId = builder.roomId;
        this.location = builder.location;
        this.floorNumber = builder.floorNumber;
        this.laundryMachines = builder.laundryMachines;
    }
    public String getRoomId() {

        return roomId;
    }
    public String getLocation() {

        return location;
    }
    public int getFloorNumber() {
        return floorNumber;
    }

    public Set<LaundryMachine> getLaundryMachines() {
        return laundryMachines;
    }

    public static class Builder {

        private String roomId;
        private String location;
        private int floorNumber;
        private Set<LaundryMachine>laundryMachines;

        public Builder setRoomId(String roomId) {
            this.roomId = roomId;
            return this;
        }
        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setFloorNumber(int floorNumber) {
            this.floorNumber = floorNumber;
            return this;
        }
        public Builder setLaundryMachines(Set<LaundryMachine>laundryMachines){
            this.laundryMachines = laundryMachines;
            return this;
        }
        public LaundryRoom build() {
            return new LaundryRoom(this);
        }
    }
}
