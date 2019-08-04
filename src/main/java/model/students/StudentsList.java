package model.students;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by aleksey.dobrovolsky on 6/3/2019.
 */
public class StudentsList {

    private List<Student> studentsList = new ArrayList<>();
    private List<Student> studentsListFiltered = new ArrayList<>();
    private Map<Integer, String> studentsMap = new HashMap<>();
    private Map<Integer, String> studentsMapFiltered = new HashMap<>();
    private String studentsDataPath = "/studentsData.csv";

    public StudentsList() {
        initFromFile();
    }

    Map<Integer, String> getStudentsMap() {
        return studentsMap;
    }

    Map<Integer, String> getStudentsMapFiltered() {
        return studentsMapFiltered;
    }

    private void initFromFile() {
        String fileData = readFromFile();
        String[] lines = fileData.split(System.getProperty("line.separator"));
        for (int i=1; i<lines.length; i++){
            String[] data = lines[i].split(",");
            studentsList.add(new Student(data[1], data[2], Integer.parseInt(data[0]), Integer.parseInt(data[3])));
        }
    }

    private String readFromFile(){
        InputStream inputStream = StudentsList.class.getResourceAsStream(studentsDataPath);
        StringBuilder text = new StringBuilder();
        int charId;

        try {
            while ((charId = inputStream.read()) != -1) {
                text.append((char) charId);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    public void printList() {
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

    public List<Student> getStudentsList() {
        return studentsList;
    }
}
