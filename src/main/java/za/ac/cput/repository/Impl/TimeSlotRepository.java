/*
 * Name:Libolwethu Nonkenke
 *Student Nr: 222665963
 * Date: 25 March 2026  */


package za.ac.cput.repository.Impl;

import za.ac.cput.domain.TimeSlot;
import za.ac.cput.repository.ITimeSlotRepository;

import java.util.HashSet;
import java.util.Set;

public class TimeSlotRepository implements ITimeSlotRepository {

    private static TimeSlotRepository repository = null;
    private Set<TimeSlot> timeSlotStorage;

    private TimeSlotRepository() {
        timeSlotStorage = new HashSet<>();
    }
    public static TimeSlotRepository getRepository() {
        if (repository == null) {
            repository = new TimeSlotRepository();
        }
        return repository;
    }
    @Override
    public TimeSlot create(TimeSlot timeSlot) {
        boolean added = timeSlotStorage.add(timeSlot);
        if (!added) {
            return null;
        }
        return timeSlot;
    }
    @Override
    public TimeSlot read(String timeSlotId) {
        return timeSlotStorage.stream()
                .filter(t -> t.getTimeSlotId().equals(timeSlotId))
                .findFirst()
                .orElse(null);
    }
    @Override
    public TimeSlot update(TimeSlot timeSlot) {
        TimeSlot existing = read(timeSlot.getTimeSlotId());
        if (existing != null) {
            timeSlotStorage.remove(existing);
            timeSlotStorage.add(timeSlot);
            return timeSlot;
        }
        return null;
    }
    @Override
    public boolean delete(String timeSlotId) {
        TimeSlot existing = read(timeSlotId);
        if (existing != null) {
            return timeSlotStorage.remove(existing);
        }
        return false;
    }
    @Override
    public Set<TimeSlot> getAll() {
        return timeSlotStorage;
    }
}
