package model.students;

import model.exceptions.NotValidEmailException;
import model.exceptions.NotValidPhoneException;

import java.util.Comparator;

import static util.Validator.isEmailValid;
import static util.Validator.isPhoneValid;

/**
 * Created by aleksey.dobrovolsky on 6/2/2019.
 */
class Student {
    private String firstName, lastName;
    private int id, age;
    static Comparator<Student> ageComparator = new Comparator<Student>() {

        public int compare(Student s1, Student s2) {
            int ageStudent1 = s1.getAge();
            int ageStudent2 = s2.getAge();

            return ageStudent1 - ageStudent2;
        }
    };
    private String email = "";
    private String phone = "";

    String getEmail() {
        return email;
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

    String getPhone() {
        return phone;
    }

    Student withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    Student withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    void withEmail(String email) throws NotValidEmailException {
        if (isEmailValid(email)) {
            this.email = email;
        } else {
            throw new NotValidEmailException("Email of " + firstName + " " + lastName + " is invalid and cannot be stored.");
        }
    }

    void withPhone(String phone) throws NotValidPhoneException {
        if (isPhoneValid(phone)) {
            this.phone = phone;
        } else {
            throw new NotValidPhoneException("Phone of " + firstName + " " + lastName + " is invalid and cannot be stored.");
        }

        this.phone = phone;
    }

    Student withId(int id) {
        this.id = id;
        return this;
    }

    Student withAge(int age) {
        this.age = age;
        return this;
    }
}
