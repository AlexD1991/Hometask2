package model.students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by aleksey.dobrovolsky on 6/3/2019.
 */
class StudentsList {

    private List<Student> studentsList = new ArrayList<>();
    private List<Student> studentsListFiltered = new ArrayList<>();
    private Map<Integer, String> studentsMap = new HashMap<>();
    private Map<Integer, String> studentsMapFiltered = new HashMap<>();

    StudentsList() {
        init();
    }

    Map<Integer, String> getStudentsMap() {
        return studentsMap;
    }

    Map<Integer, String> getStudentsMapFiltered() {
        return studentsMapFiltered;
    }

    private StudentsList init() {
        String[] firstNames = {"Olivia", "Amelia", "Isla", "Emily", "Ava", "Oliver", "Harry", "Jack", "George", "Noah"};
        String[] lastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
        int[] ages = {18, 20, 21, 22, 18, 18, 19, 23, 23, 20};
        int[] ids = {96, 97, 98, 99, 100, 101, 102, 103, 104, 105};

        for (int i = 0; i < 10; i++) {
            studentsList.add(new Student(firstNames[i], lastNames[i], ids[i], ages[i]));
        }
        return this;
    }

    void printList() {
        System.out.println("id\tfirst name\tlast name\tage");
        for (Student st : studentsList) {
            System.out.println(String.format("%s\t%s\t%s\t%s",
                    st.getId(), st.getFirstName(), st.getLastName(), st.getAge()));
        }
    }

    void printFilteredList() {
        System.out.println("id\tfirst name\tlast name\tage");
        for (Student st : studentsListFiltered) {
            System.out.println(String.format("%s\t%s\t%s\t%s",
                    st.getId(), st.getFirstName(), st.getLastName(), st.getAge()));
        }
    }


    StudentsList filterByLastName(String letter) {
        for (Student st : studentsList) {
            if (st.getLastName().startsWith(letter)) studentsListFiltered.add(st);
        }
        return this;
    }

    double getAverageAge() {
        double result = 0;
        for (Student st : studentsList) {
            result += st.getAge();
        }
        return result / studentsList.size();
    }

    StudentsList convertToMap() {
        for (Student st : studentsList) {
            studentsMap.put(st.getId(), st.getFirstName() + " " + st.getLastName() + " " + st.getAge());
        }
        return this;
    }

    StudentsList filterMapById() {
        for (Map.Entry<Integer, String> entry : studentsMap.entrySet()) {
            if (entry.getKey() > 100) studentsMapFiltered.put(entry.getKey(), entry.getValue());
        }
        return this;
    }

    StudentsList sortByAge() {
        studentsList.sort(Student.ageComparator);
        return this;
    }

    StudentsList sortByAgeStream() {
        studentsList.stream()
                .sorted(Student.ageComparator)
                .collect(Collectors.toList());
        return this;
    }

    StudentsList filterByLastNameStream(String letter) {
        studentsListFiltered = studentsList.stream()
                .filter(x -> x.getLastName().startsWith(letter))
                .collect(Collectors.toList());
        return this;
    }

    double getAverageAgeStream() {
        return studentsList.stream()
                .mapToDouble(Student::getAge)
                .average()
                .orElse(0);
    }

    StudentsList convertToMapStream() {
        studentsMap = studentsList.stream().collect(
                Collectors.toMap(Student::getId, x -> x.getFirstName() + " " + x.getLastName() + " " + x.getAge()));
        return this;
    }

    StudentsList filterMapByIdStream() {
        studentsMapFiltered = studentsMap.entrySet()
                .stream()
                .filter(x -> x.getKey() > 100)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return this;
    }
}
