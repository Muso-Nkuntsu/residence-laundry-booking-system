package za.ac.cput;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.LaundryMachine;
import za.ac.cput.domain.MachineStatus;
import za.ac.cput.factory.LaundryMachineFactory;

import static org.junit.jupiter.api.Assertions.*;

class LaundryMachineFactoryTest {

    @Test
    void createLaundryMachine() {
        LaundryMachine machine = LaundryMachineFactory.createLaundryMachine(
                "M001",
                1,
                MachineStatus.AVAILABLE
        );

        assertNotNull(machine);
        assertEquals("M001", machine.getMachineId());
        assertEquals(1, machine.getMachineNumber());
        assertEquals("AVAILABLE", machine.getStatus());
    }

    @Test
    void createLaundryMachineInvalid() {
        LaundryMachine machine = LaundryMachineFactory.createLaundryMachine(
                "",
                -1,
                null
        );

        assertNull(machine);
    }
}
