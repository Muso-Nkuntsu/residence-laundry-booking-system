package za.ac.cput.factory;

import za.ac.cput.domain.LaundryRoom;

public class LaundryRoomFactory {

    public static LaundryRoom createLaundryRoom(String roomId, String location,
                                                int floorNumber){

        if (roomId == null || roomId.isEmpty())
            throw new IllegalArgumentException("roomId cannot be null or empty");
        if (location == null || location.isEmpty())
            throw new IllegalArgumentException("location cannot be null or empty");
        if (floorNumber < 0)
            throw new IllegalArgumentException("floorNumber cannot be negative");

        return new LaundryRoom.Builder()
                .setRoomId(roomId)
                .setLocation(location)
                .setFloorNumber(floorNumber)
                .build();
    }
}
