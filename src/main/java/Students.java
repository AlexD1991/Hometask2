import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by aleksey.dobrovolsky on 6/2/2019.
 */
public class Students {
//    private static List<Student> students = new ArrayList<Student>();

    public static void main(String[] args) {
        List<Student> students = init();
        resultList(sortByAge(students));
        resultList(students);
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
}