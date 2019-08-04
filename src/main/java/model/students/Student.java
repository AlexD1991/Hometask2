package model.students;

import java.util.Comparator;

/**
 * Created by aleksey.dobrovolsky on 6/2/2019.
 */
public class Student {
    static Comparator<Student> ageComparator = new Comparator<Student>() {

        public int compare(Student s1, Student s2) {
            int ageStudent1 = s1.getAge();
            int ageStudent2 = s2.getAge();

            return ageStudent1 - ageStudent2;
        }
    };
    private String firstName, lastName;
    private int id, age;

    Student(String firstName, String lastName, int id, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = id;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    int getId() {
        return id;
    }

    int getAge() {
        return age;
    }
}
