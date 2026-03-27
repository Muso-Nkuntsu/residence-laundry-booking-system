/*
 * Name:Lindokuhle Nanto
 * Student Nr:240443608
 * Date: 24 March 2026
 * */

package za.ac.cput.repository.Impl;

import za.ac.cput.domain.LaundryMachine;
import za.ac.cput.repository.ILaundryMachineRepository;

import java.util.HashSet;
import java.util.Set;

public class LaundryMachineRepository implements ILaundryMachineRepository{
    private static LaundryMachineRepository repository = null;
    private Set<LaundryMachine> laundryMachineSet;

    private LaundryMachineRepository() {
        laundryMachineSet = new HashSet<>();
    }

    public static LaundryMachineRepository getRepository() {
        if (repository == null) {
            repository = new LaundryMachineRepository();
        }
        return repository;
    }

    @Override
    public LaundryMachine create(LaundryMachine machine) {
        laundryMachineSet.add(machine);
        return machine;
    }

    @Override
    public LaundryMachine read(String machineId) {
        for (LaundryMachine machine : laundryMachineSet) {
            if (machine.getMachineId().equals(machineId)) {
                return machine;
            }
        }
        return null;
    }

    @Override
    public LaundryMachine update(LaundryMachine machine) {
        LaundryMachine oldMachine = read(machine.getMachineId());
        if (oldMachine != null) {
            laundryMachineSet.remove(oldMachine);
            laundryMachineSet.add(machine);
            return machine;
        }
        return null;
    }

    @Override
    public boolean delete(String machineId) {
        LaundryMachine machine = read(machineId);
        if (machine != null) {
            laundryMachineSet.remove(machine);
            return true;
        }
        return false;
    }

    @Override
    public Set<LaundryMachine> getAll() {
        return laundryMachineSet;
    }
}
