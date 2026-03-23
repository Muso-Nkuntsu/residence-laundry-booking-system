package za.ac.cput.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.LaundryMachine;
import za.ac.cput.domain.LaundryRoom;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LaundryRoomRepositoryTest {

    private LaundryRoomRepository repository;
    private LaundryRoom laundryRoom;

    @BeforeEach
    void setUp(){
        repository = LaundryRoomRepository.getRepository();

        Set<LaundryMachine> machines = new HashSet<>();
        machines.add(new LaundryMachine.Builder()
                .setMachineId("M1")
                .setMachineNumber(1)
                .setStatus("Available")
                .build());

        laundryRoom = new LaundryRoom.Builder()
                .setRoomId("R1")
                .setLocation("First Floor")
                .setFloorNumber(1)
                .setLaundryMachines(machines)
                .build();
    }

    @Test
    void testCreate(){
        LaundryRoom created = repository.create(laundryRoom);
        assertNotNull(created);
        assertEquals("First Floor", created.getLocation());
    }

    @Test
    void testUpdate(){
        repository.create(laundryRoom);

        LaundryRoom updated = new LaundryRoom.Builder()
                .setRoomId("R1")
                .setLocation("Second Floor")
                .setFloorNumber(2)
                .setLaundryMachines(laundryRoom.getLaundryMachines())
                .build();

        LaundryRoom result = repository.update(updated);
        assertNotNull(result);
        assertEquals("Second Floor", result.getLocation());
    }

    @Test
    void testDelete(){
        repository.create(laundryRoom);
        boolean deleted = repository.delete("R1");
        assertTrue(deleted);
    }

    @Test
    void testGetAll(){
        repository.create(laundryRoom);
        Set<LaundryRoom> rooms = repository.getAll();
        assertFalse(rooms.isEmpty());
    }
}
