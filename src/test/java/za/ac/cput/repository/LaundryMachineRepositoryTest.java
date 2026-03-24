package za.ac.cput.repository.impl;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.LaundryMachine;
import za.ac.cput.repository.LaundryMachineRepository;

import static org.junit.jupiter.api.Assertions.*;

public class LaundryMachineRepositoryTest {
    private final LaundryMachineRepository repository = LaundryMachineRepository.getRepository();

    private LaundryMachine machine = new LaundryMachine.Builder()
            .setMachineId("M001")
            .setMachineNumber(1)
            .setStatus("AVAILABLE")
            .build();

    @Test
    void create() {
        LaundryMachine created = repository.create(machine);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void read() {
        repository.create(machine);
        LaundryMachine read = repository.read("M001");
        assertNotNull(read);
    }

    @Test
    void update() {
        repository.create(machine);

        LaundryMachine updatedMachine = new LaundryMachine.Builder()
                .setMachineId("M001")
                .setMachineNumber(2)
                .setStatus("IN_USE")
                .build();

        LaundryMachine updated = repository.update(updatedMachine);
        assertNotNull(updated);
        assertEquals(2, updated.getMachineNumber());
    }

    @Test
    void delete() {
        repository.create(machine);
        boolean deleted = repository.delete("M001");
        assertTrue(deleted);
    }

    @Test
    void getAll() {
        repository.create(machine);
        assertFalse(repository.getAll().isEmpty());
    }
}
