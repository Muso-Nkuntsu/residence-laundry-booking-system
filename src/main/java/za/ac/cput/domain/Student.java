package za.ac.cput.domain;

public class Student {
    private final String studentId;
    private final String name;
    private final String surname;
    private final String email;

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

    public static class Builder{
        private String studentId;
        private String name;
        private String surname;
        private String email;

        public Builder setStudentId(String studentId){
            this.studentId = studentId;
            return this;
        }
        public Builder setName(String name){
            this.name = name;
            return this;
        }
        public Builder setSurname(String surname){
            this.surname = surname;
            return this;
        }
        public Builder setEmail(String email){
            this.email = email;
            return this;
        }
        public Student build(){
            return new Student(this);
        }
    }

}
