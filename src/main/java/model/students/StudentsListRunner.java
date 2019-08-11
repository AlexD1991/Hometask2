package model.students;

import static util.Writer.clearFile;
import static util.Writer.writeToFile;

/**
 * Created by aleksey.dobrovolsky on 7/7/2019.
 */
public class StudentsListRunner {

    private StudentsList students = new StudentsList();
    private String studentsOutputPath = students.getStudentsOutputPath();

    public void runClassic() {

        clearFile(studentsOutputPath);

        writeToFile("\nInitial list:\n", studentsOutputPath);
        students.printList();

        writeToFile("\nSorted by age list:\n", studentsOutputPath);
        students.sortByAge().printList();

        writeToFile("\nOnly students which last name starts with 'J' letter:\n", studentsOutputPath);
        students.filterByLastName("J").printFilteredList();

        writeToFile("\nThe average age:\n", studentsOutputPath);
        writeToFile(String.valueOf(students.getAverageAge()), studentsOutputPath);

        writeToFile("\nConverted list to HashMap:\n", studentsOutputPath);
        writeToFile(String.valueOf(students.convertToMap().getStudentsMap()), studentsOutputPath);

        writeToFile("\nSet that contains students with id more then 100:\n", studentsOutputPath);
        writeToFile(String.valueOf(students.filterMapById().getStudentsMapFiltered()), studentsOutputPath);

        System.out.println("Results have been added to the file " + studentsOutputPath);
    }

    public void runStream() {

        clearFile(studentsOutputPath);

        writeToFile("\nInitial list:\n", studentsOutputPath);
        students.printList();

        writeToFile("\nSorted by age list:\n", studentsOutputPath);
        students.sortByAgeStream().printList();

        writeToFile("\nOnly students which last name starts with 'J' letter:\n", studentsOutputPath);
        students.filterByLastNameStream("J").printFilteredList();

        writeToFile("\nThe average age:\n", studentsOutputPath);
        writeToFile(String.valueOf(students.getAverageAgeStream()), studentsOutputPath);

        writeToFile("\nConverted list to HashMap:\n", studentsOutputPath);
        writeToFile(String.valueOf(students.convertToMapStream().getStudentsMap()), studentsOutputPath);

        writeToFile("\nSet that contains students with id more then 100\n", studentsOutputPath);
        writeToFile(String.valueOf(students.filterMapByIdStream().getStudentsMapFiltered()), studentsOutputPath);

        System.out.println("Results have been added to the file " + studentsOutputPath);
    }


}
