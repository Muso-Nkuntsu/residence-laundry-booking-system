package za.ac.cput.repository;
import org.junit.jupiter.api.*;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.StudentFactory;
import static org.junit.jupiter.api.Assertions.*;

 class StudentRepoTest {
     private StudentRepository repository;
     private Student student;

     @BeforeEach
     void setUp(){
         repository = StudentRepository.getRepository();
         student = StudentFactory.createStudent("231223558", "Muso","Nkuntsu", "2312235582@mycput.ac.za");
     }

     @Test
     void create(){
         Student created = repository.create(student);
         assertNotNull(created);
         assertEquals(student.getStudentId(),created.getStudentId());
     }
     @Test
     void read(){
         repository.create(student);
         Student read = repository.read("231223558");
         assertNotNull(read);
         assertEquals("Muso", read.getName());
     }
     @Test
     void update(){
         repository.create(student);
         Student updatedStudent = StudentFactory.createStudent("231223558", "Muso","Nkuntsu", "2312235582@mycput.ac.za");
         Student updated = repository.update(updatedStudent);
         assertNotNull(updated);
         assertEquals("Muso Updated ", updated.getName());
     }
     @Test
     void delete(){
         repository.create(student);
         boolean deleted = repository.delete("231223558");
         assertTrue(deleted);
     }
     @Test
     void getAll(){
         repository.create(student);
         assertFalse(repository.getAll().isEmpty());
     }
}
