package za.ac.cput.domain;

import java.util.Objects;

public class Student {
    private  String studentId;
    private  String name;
    private  String surname;
    private  String email;

    private Student(Builder builder){
        this.studentId = builder.studentId;
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;
    }
    public String getStudentId() {return studentId;}
    public String getName() {return name;}
    public String getSurname() {return surname;}
    public String getEmail() {return email;}

    public static class Builder {
        private String studentId;
        private String name;
        private String surname;
        private String email;

        public Builder setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder copy(Student student) {
            this.studentId = student.studentId;
            this.name = student.name;
            this.surname = student.surname;
            this.email = student.email;
            return this;

        }
        public Student build(){
            return new Student(this);
        }

    }
    //=================================================================
    //Changes made:27/03/2026
    @Override
    public String toString() {
        return "INFORMATION:" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId) && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, name, surname, email);
    }
}
