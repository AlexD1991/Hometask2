package controller;

import model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aleksey.dobrovolsky on 6/3/2019.
 */
public class StudentsList {

    public static List<Student> students = init();



    private static List<Student> init() {
        List<Student> students = new ArrayList<Student>();
        String[] firstNames = {"Olivia", "Amelia", "Isla", "Emily", "Ava", "Oliver", "Harry", "Jack", "George", "Noah"};
        String[] lastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
        int[] ages = {18, 20, 21, 22, 18, 18, 19, 23, 23, 20};
        int[] ids = {96, 97, 98, 99, 100, 101, 102, 103, 104, 105};

        for (int i = 0; i < 10; i++) {
            students.add(new Student(firstNames[i], lastNames[i], ids[i], ages[i]));
        }
        return students;
    }

    public static void resultList(List<Student> list) {
        System.out.println("id\tfirst name\tlast name\tage");
        for (Student st : list) {
            System.out.println(String.format("%s\t%s\t%s\t%s",
                    st.getId(), st.getFirstName(), st.getLastName(), st.getAge()));
        }
    }
}
