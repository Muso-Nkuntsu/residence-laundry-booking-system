package za.ac.cput.factory;

import za.ac.cput.domain.LaundryRoom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LaundryRoomFactoryTest {

    @Test
    void testCreateLaundryRoom(){

        String roomId = "LR001";
        String location = "Block A, NMJ";
        int floorNumber = 5;

        LaundryRoom laundryRoom = LaundryRoomFactory.createLaundryRoom(roomId, location, floorNumber);

        assertNotNull(laundryRoom);
        assertEquals(roomId, laundryRoom.getRoomId());
        assertEquals(location, laundryRoom.getLocation());
        assertEquals(floorNumber, laundryRoom.getFloorNumber());

    }


}
