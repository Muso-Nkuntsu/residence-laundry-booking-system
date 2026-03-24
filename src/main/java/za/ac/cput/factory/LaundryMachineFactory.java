package za.ac.cput.factory;
import za.ac.cput.domain.LaundryMachine;
import za.ac.cput.domain.MachineStatus;

public class LaundryMachineFactory {
    public static LaundryMachine createLaundryMachine(String machineId, int machineNumber, MachineStatus status) {

        if (machineId == null || machineId.isEmpty())
            return null;

        if (machineNumber <= 0)
            return null;

        if (status == null)
            return null;

        return new LaundryMachine.Builder()
                .setMachineId(machineId)
                .setMachineNumber(machineNumber)
                .setStatus(status.name())
                .build();
    }
}
