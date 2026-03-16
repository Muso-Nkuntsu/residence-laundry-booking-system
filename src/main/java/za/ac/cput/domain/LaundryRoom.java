package za.ac.cput.domain;

public class LaundryRoom {

    private String roomId;
    private String location;
    private int floorNumber;


    private LaundryRoom(Builder builder) {
        this.roomId = builder.roomId;
        this.location = builder.location;
        this.floorNumber = builder.floorNumber;
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

    public static class Builder {

        private String roomId;
        private String location;
        private int floorNumber;

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
        public LaundryRoom build() {
            return new LaundryRoom(this);
        }
    }
}
