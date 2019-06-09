package model;

import java.util.Comparator;

/**
 * Created by aleksey.dobrovolsky on 6/2/2019.
 */
public class Student {
    private String firstName, lastName;
    private int id, age;

    public Student(String firstName, String lastName, int id, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static Comparator<Student> ageComparator = new Comparator<Student>() {

        public int compare(Student s1, Student s2) {
            int ageStudent1 = s1.getAge();
            int ageStudent2 = s2.getAge();

            return ageStudent1 - ageStudent2;
        }
    };
}
