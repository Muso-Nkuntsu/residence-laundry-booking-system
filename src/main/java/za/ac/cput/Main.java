package za.ac.cput;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.LaundryMachine;
import za.ac.cput.domain.MachineStatus;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.TimeSlot;
import za.ac.cput.factory.BookingFactory;
import za.ac.cput.factory.LaundryMachineFactory;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.repository.BookingRepository;
import za.ac.cput.repository.LaundryMachineRepository;
import za.ac.cput.repository.StudentRepository;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println(" RESIDENCE LAUNDRY BOOKING SYSTEM SIMULATION");
        System.out.println("====================================================\n");

        StudentRepository studentRepo = StudentRepository.getRepository();
        LaundryMachineRepository machineRepo = LaundryMachineRepository.getRepository();
        BookingRepository bookRepo = BookingRepository.getRepository();

        setupMockData(studentRepo, machineRepo);

        Student s1 = studentRepo.read("231223722");
        Student s2 = studentRepo.read("238878778");
        LaundryMachine m1 = machineRepo.read("LM001");
        TimeSlot ts = new TimeSlot.Builder()
                .setStartTime(LocalTime.of(10, 0))
                .setEndTime(LocalTime.of(11, 0))
                .build();

        if (s1 != null && m1 != null) {
            Booking b1 = BookingFactory.createBooking("B87",
                    LocalDate.now(),
                    "Confirmed",
                    s1,
                    m1,
                    ts);
            bookRepo.create(b1);
        }
        displaySystemState(studentRepo,machineRepo,bookRepo);

        performUpdate(studentRepo, "231223722", "Simamkele");
        performDelete(studentRepo, "238878778");
        System.out.println("\n-- Final system Audit ---");
        displaySystemState(studentRepo, machineRepo, bookRepo);
        System.out.println("Success!!");
    }
    private static void setupMockData(StudentRepository sRepo, LaundryMachineRepository mRepo){
        sRepo.create(StudentFactory.createStudent("231223722", "Muso", "Nkuntsu", "231223722@mycput.com"));
        sRepo.create(StudentFactory.createStudent("238878778", "Talent", "Nocuze", "23887877@mycput.com"));
        sRepo.create(StudentFactory.createStudent("256225789", "Sabo", "Ndaba", "256225789@mycput.com"));
        sRepo.create(StudentFactory.createStudent("254556877", "Libo", "Nonkenke", "254556877@mycput.com"));
        sRepo.create(StudentFactory.createStudent("278688778", "Lindo", "Nanto", "278688778@mycput.com"));

        mRepo.create(LaundryMachineFactory.createLaundryMachine("LM001",1, MachineStatus.AVAILABLE));
        mRepo.create(LaundryMachineFactory.createLaundryMachine("LM006",   5, MachineStatus.OUT_OF_ORDER));
        mRepo.create(LaundryMachineFactory.createLaundryMachine("LM012",  7, MachineStatus.AVAILABLE));
        mRepo.create(LaundryMachineFactory.createLaundryMachine("LM016",  8, MachineStatus.IN_USE));
        mRepo.create(LaundryMachineFactory.createLaundryMachine("LM021",  9, MachineStatus.AVAILABLE));
    }
    private static void performUpdate(StudentRepository sRepo, String id, String newName) {
        System.out.println("\nUpdateing Studnt ID: " + id);
        Student found = sRepo.read(id);
        if (found != null) {
            Student updated = new Student.Builder().copy(found).setName(newName).build();
            sRepo.update(updated);
            System.out.println("RESULT:Name changed to " + updated.getName());
        }
    }
        private static void performDelete(StudentRepository sRepo, String id){
            System.out.println("\n Deleting Student ID: " + id);
            if (sRepo.delete(id)) {
                System.out.println("Results:Successfully removed. ");
            }
        }
        private static void displaySystemState(StudentRepository sRepo, LaundryMachineRepository mRepo, BookingRepository bookingRepo){
            System.out.print("\n------Current System State------\n");
            System.out.println("Students: " + sRepo.getAll().size());
            System.out.println("Machines: "+ mRepo.getAll().size());
            System.out.println("Bookings: "+ bookingRepo.getAll().size());

            if (!bookingRepo.getAll().isEmpty()) {
                System.out.println("Active bookings: ");
                bookingRepo.getAll().forEach(booking -> System.out.println(" > " + booking));
            }
    }
}


