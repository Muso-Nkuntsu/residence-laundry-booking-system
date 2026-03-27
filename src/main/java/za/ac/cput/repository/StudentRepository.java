package za.ac.cput.repository;

import java.util.HashSet;
import java.util.Set;
import za.ac.cput.repository.IStudentRepository;
import za.ac.cput.domain.Student;

public class StudentRepository implements IStudentRepository {
    public static StudentRepository repository = null;
    private Set<Student> studentDB;

    private StudentRepository(){
        studentDB = new HashSet<>();
    }
    public static StudentRepository getRepository(){
        if (repository == null) {
            repository = new StudentRepository();
        }
        return repository;
    }
    @Override
    public Student create(Student student){
        if( existsById(student.getStudentId())){
            return null;
        }
        studentDB.add(student);
        return student;
    }
    @Override
    public Student read(String studentId){
        return studentDB.stream()
                .filter(s -> s.getStudentId().equals(studentId))
                .findFirst()
                .orElse(null);
    }
    @Override
    public Student update(Student student){
        Student existing = read(student.getStudentId());
        if (existing != null) {
            studentDB.remove(existing);
            studentDB.add(student);
            return student;
        }
        return null;
    }
    @Override
    public boolean delete(String studentId){
        Student existing = read(studentId);
        if (existing != null) {
            studentDB.remove(existing);
            return true;
        }
        return false;
    }
    @Override
    public Set<Student> getAll(){
        return studentDB;
    }
    @Override
    public Student findByEmail(String email){
        return studentDB.stream()
                .filter(s->s.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }
    @Override
    public boolean existsById(String studentId){
        return studentDB.stream()
                .anyMatch(s-> s.getStudentId().equals(studentId));
    }

}
