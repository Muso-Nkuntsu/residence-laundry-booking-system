package za.ac.cput.repository;

import za.ac.cput.domain.Student;
public interface IStudentRepository extends IRepository<Student, String>{
    Student findByEmail(String email);

    boolean existsById(String studentId);
}
