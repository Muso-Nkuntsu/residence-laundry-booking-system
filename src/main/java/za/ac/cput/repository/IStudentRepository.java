package za.ac.cput.repository;

import za.ac.cput.domain.Student;
public interface IStudentRepository extends iRepository<Student, String>{
    Student findByEmail(String email);

    boolean existsById(String studentId);
}
