import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by aleksey.dobrovolsky on 6/3/2019.
 */
public class StudentsOperationsStream {

    static List<Student> students = StudentsList.students;

    static void run() {
        System.out.println("\nInitial list:");
        StudentsList.resultList(students);

        System.out.println("\nSorted by age list:");
        StudentsList.resultList(
                StudentsOperationsStream.sortByAgeStream(StudentsOperationsStream.students));

        System.out.println("\nOnly students which last name starts with 'J' letter:");
        StudentsList.resultList(
                StudentsOperationsStream.filterByLastNameStream(StudentsOperationsStream.students, "J"));

        System.out.println("\nThe average age:");
        System.out.println(StudentsOperationsStream.getAverageAgeStream(StudentsOperationsStream.students));

        System.out.println("\nConverted list to HashMap:");
        System.out.println(StudentsOperationsStream.convertToMapStream(StudentsOperationsStream.students));

        System.out.println("\nSet that contains students with id more then 100");
        System.out.println(StudentsOperationsStream.filterMapByIdStream(StudentsOperationsStream.convertToMapStream(StudentsOperationsStream.students)));
    }

    static List<Student> sortByAgeStream(List<Student> list) {
        return list.stream()
                .sorted(Student.ageComparator)
                .collect(Collectors.toList());
    }

    static List<Student> filterByLastNameStream(List<Student> list, String letter) {
        return list.stream().filter(x -> x.getLastName().startsWith(letter)).collect(Collectors.toList());
    }

    static double getAverageAgeStream(List<Student> list) {
        return list.stream()
                .mapToDouble(Student::getAge)
                .average()
                .orElse(0);
    }

    static Map<Integer, String> convertToMapStream(List<Student> list) {
        return list.stream().collect(
                Collectors.toMap(Student::getId, x -> x.getFirstName() + " " + x.getLastName() + " " + x.getAge()));
    }

    static Set<Map.Entry<Integer, String>> filterMapByIdStream(Map<Integer, String> map) {
        return map.entrySet().stream().filter(x -> x.getKey() > 100).collect(Collectors.toSet());
    }

}
