import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by aleksey.dobrovolsky on 6/2/2019.
 */
public class Students {

    public static void main(String[] args) {
        List<Student> students = init();
        resultList(sortByAge(students));
        resultList(filterByLastName(students, "J"));
        System.out.println(getAverageAge(students));
        System.out.println(convertToMap(students));
    }

    private static List<Student> init() {
        List<Student> students = new ArrayList<Student>();
        String[] firstNames = {"Olivia", "Amelia", "Isla", "Emily", "Ava", "Oliver", "Harry", "Jack", "George", "Noah"};
        String[] lastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
        int[] ages = {18, 20, 21, 22, 18, 18, 19, 23, 23, 20};

        for (int i = 0; i < 10; i++) {
            students.add(new Student(firstNames[i], lastNames[i], i, ages[i]));
        }
        return students;
    }

    private static List<Student> sortByAge(List<Student> list) {
        Collections.sort(list, Student.ageComparator);
        return list;
    }

    private static void resultList(List<Student> list) {
        System.out.println("id\tfirst name\tlast name\tage");
        for (Student st : list) {
            System.out.println(String.format("%s\t%s\t%s\t%s",
                    st.getId(), st.getFirstName(), st.getLastName(), st.getAge()));
        }
    }

    private static List<Student> filterByLastName(List<Student> list, String letter) {
        ArrayList<Student> result = new ArrayList<Student>();
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

    private static Map<Integer, String> convertToMapLambda(List<Student> list) {
        return list.stream().collect(
                Collectors.toMap(Student::getId, x -> x.getFirstName() + " " + x.getLastName() + " " + x.getAge()));
    }

    private static Map<Integer, String> convertToMap(List<Student> list) {
        Map<Integer, String> map = new HashMap<>();
        for (Student st : list) {
            map.put(st.getId(), st.getFirstName() + " " + st.getLastName() + " " + st.getAge());
        }
        return map;
    }

}
