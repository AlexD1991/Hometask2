package controller;

import model.Student;

import java.util.*;

import static controller.StudentsList.getStudents;

/**
 * Created by aleksey.dobrovolsky on 6/2/2019.
 */
public class StudentsOperationsClassic {

    private static List<Student> students = getStudents();

    public static void run() {
        System.out.println("\nInitial list:");
        StudentsList.resultList(students);

        System.out.println("\nSorted by age list:");
        StudentsList.resultList(
                StudentsOperationsClassic.sortByAge(StudentsOperationsClassic.students));

        System.out.println("\nOnly students which last name starts with 'J' letter:");
        StudentsList.resultList(
                StudentsOperationsClassic.filterByLastName(StudentsOperationsClassic.students, "J"));

        System.out.println("\nThe average age:");
        System.out.println(StudentsOperationsClassic.getAverageAge(StudentsOperationsClassic.students));

        System.out.println("\nConverted list to HashMap:");
        System.out.println(StudentsOperationsClassic.convertToMap(StudentsOperationsClassic.students));

        System.out.println("\nSet that contains students with id more then 100");
        System.out.println(StudentsOperationsClassic.filterMapById(StudentsOperationsClassic.convertToMap(StudentsOperationsClassic.students)));
    }

    private static List<Student> sortByAge(List<Student> list) {
        list.sort(Student.ageComparator);
        return list;
    }

    private static List<Student> filterByLastName(List<Student> list, String letter) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student st : list) {
            if (st.getLastName().startsWith(letter)) result.add(st);
        }
        return result;
    }

    private static double getAverageAge(List<Student> list) {
        double result = 0;
        for (Student st : list) {
            result += st.getAge();
        }
        return result / list.size();
    }

    private static Map<Integer, String> convertToMap(List<Student> list) {
        Map<Integer, String> map = new HashMap<>();
        for (Student st : list) {
            map.put(st.getId(), st.getFirstName() + " " + st.getLastName() + " " + st.getAge());
        }
        return map;
    }

    private static Map<Integer, String> filterMapById(Map<Integer, String> map) {
        Map<Integer, String> resultMap = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 100) resultMap.put(entry.getKey(), entry.getValue());
        }
        return resultMap;
    }

}
