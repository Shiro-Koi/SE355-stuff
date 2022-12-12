import java.io.*;
import java.net.*;

public class Student implements Serializable {
    String firstName;
    String lastName;
    int age;
    double gpa;
    Department[] dept = new Department[10];

    public Student(String firstName, String lastName, int age, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gpa = gpa;
    }

    public Student() {

    }

}

class Department {
    int id;
    String name;
}