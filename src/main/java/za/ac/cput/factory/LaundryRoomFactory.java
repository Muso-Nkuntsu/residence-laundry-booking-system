package za.ac.cput.factory;

import za.ac.cput.domain.LaundryRoom;

public class LaundryRoomFactory {

    public static LaundryRoom createLaundryRoom(String roomId, String location,
                                                int floorNumber){

        return new LaundryRoom.Builder()
                .setRoomId(roomId)
                .setLocation(location)
                .setFloorNumber(floorNumber)
                .build();
    }
}
