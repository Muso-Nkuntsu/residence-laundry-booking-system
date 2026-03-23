package za.ac.cput.factory;

import za.ac.cput.domain.Student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

 class StudentTest {
  @Test
  void createStudent_ValidInput_ShouldCreateStudent() {
   // Arrange & Act
   Student student = StudentFactory.createStudent(
           "221001122",
           "John",
           "Doe",
           "john.doe@cput.ac.za"
   );

   assertNotNull(student);
   assertEquals("221001122", student.getStudentId());
   assertEquals("John", student.getName());
   assertEquals("Doe", student.getSurname());
   assertEquals("john.doe@cput.ac.za", student.getEmail());
  }

  @Test
  void createStudent_InvalidEmail_ShouldThrowException() {
   assertThrows(IllegalArgumentException.class, () ->
           StudentFactory.createStudent("221001122", "John", "Doe", "invalid-email")
   );
  }

  @Test
  void createStudent_NullStudentId_ShouldThrowException() {
   assertThrows(IllegalArgumentException.class, () ->
           StudentFactory.createStudent(null, "John", "Doe", "john.doe@cput.ac.za")
   );
  }

  @Test
  void createStudent_EmptyName_ShouldThrowException() {
   assertThrows(IllegalArgumentException.class, () ->
           StudentFactory.createStudent("221001122", "", "Doe", "john.doe@cput.ac.za")
   );
  }

  @Test
  void createStudent_NullSurname_ShouldThrowException() {
   assertThrows(IllegalArgumentException.class, () ->
           StudentFactory.createStudent("221001122", "John", null, "john.doe@cput.ac.za")
   );
  }

  @Test
  void createStudent_NullEmail_ShouldThrowException() {
   assertThrows(IllegalArgumentException.class, () ->
           StudentFactory.createStudent("221001122", "John", "Doe", null)
   );
  }
}
