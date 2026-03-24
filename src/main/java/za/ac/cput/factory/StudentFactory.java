package za.ac.cput.factory;
import za.ac.cput.domain.Student;
import za.ac.cput.util.Helpler;

public class StudentFactory {
    public static Student createStudent(String studentId, String name, String surname, String email) {
        if (Helpler.isNullOrEmpty(studentId)) {
            throw new IllegalArgumentException("Student ID is rquired");
        }
        if (Helpler.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Name is required");
        }
        if (Helpler.isNullOrEmpty(surname)) {
            throw new IllegalArgumentException("Surname is required");
        }
        if(Helpler.isNullOrEmpty(email) || !Helpler.isValidEmail(email)){
            throw new IllegalArgumentException("Invalid email");

        }
        return  new Student.Builder()
                .setStudentId(studentId)
                .setName(name)
                .setSurname(surname)
                .setEmail(email).build();
    }
}