package za.ac.cput.repository;

import java.util.HashSet;
import java.util.Set;
import za.ac.cput.repository.IStudentRepository;
import za.ac.cput.domain.Student;

public class StudentRepository implements IStudentRepository {
    public static StudentRepository repository = null;
    private Set<Student> studentStorage;

    private StudentRepository(){
        studentStorage = new HashSet<>();
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
        studentStorage.add(student);
        return student;
    }
    @Override
    public Student read(String studentId){
        return studentStorage.stream()
                .filter(s -> s.getStudentId().equals(studentId))
                .findFirst()
                .orElse(null);
    }
    @Override
    public Student update(Student student){
        Student existing = read(student.getStudentId());
        if (existing != null) {
            studentStorage.remove(existing);
            studentStorage.add(student);
            return student;
        }
        return null;
    }
    @Override
    public boolean delete(String studentId){
        if (studentId != null) {
            studentStorage.remove(studentId);
            return true;
        }
        return false;
    }
    @Override
    public Set<Student> getAll(){
        return studentStorage;
    }
    @Override
    public Student findByEmail(String email){
        return studentStorage.stream()
                .filter(s->s.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }
    @Override
    public boolean existsById(String studentId){
        return studentStorage.stream()
                .anyMatch(s-> s.getStudentId().equals(studentId));
    }

}
