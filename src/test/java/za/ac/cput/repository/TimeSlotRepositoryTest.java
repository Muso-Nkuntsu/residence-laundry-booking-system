package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.TimeSlot;
import za.ac.cput.factory.TimeSlotFactory;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

class TimeSlotRepositoryTest {
    private TimeSlotRepository repository;
    private TimeSlot timeSlot;
    @BeforeEach
    void setUp() {
        repository = TimeSlotRepository.getRepository();

        timeSlot = TimeSlotFactory.createTimeSlot(
                "444",
                LocalTime.parse("04:00"),
                LocalTime.parse("05:00")
        );
    }
    @Test
    void update() {
        repository.create(timeSlot);
        TimeSlot updatedTimeSlot = TimeSlotFactory.createTimeSlot(
                "444",
                LocalTime.parse("04:00"),
                LocalTime.parse("06:00")
        );
        TimeSlot updated = repository.update(updatedTimeSlot);
        assertNotNull(updated);
        assertEquals(LocalTime.parse("08:00"), updated.getStartTime());
    }
}