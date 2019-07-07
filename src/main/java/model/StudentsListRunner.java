package model;

/**
 * Created by aleksey.dobrovolsky on 7/7/2019.
 */
public class StudentsListRunner {

    private StudentsList students = new StudentsList();

    public void runClassic() {
        System.out.println("\nInitial list:");
        students.printList();

        System.out.println("\nSorted by age list:");
        students.sortByAge().printList();

        System.out.println("\nOnly students which last name starts with 'J' letter:");
        students.filterByLastName("J").printFilteredList();

        System.out.println("\nThe average age:");
        System.out.println(students.getAverageAge());

        System.out.println("\nConverted list to HashMap:");
        System.out.println(students.convertToMap().getStudentsMap());

        System.out.println("\nSet that contains students with id more then 100");
        System.out.println(students.filterMapById().getStudentsMapFiltered());
    }

    public void runStream() {
        System.out.println("\nInitial list:");
        students.printList();

        System.out.println("\nSorted by age list:");
        students.sortByAgeStream().printList();

        System.out.println("\nOnly students which last name starts with 'J' letter:");
        students.filterByLastNameStream("J").printFilteredList();

        System.out.println("\nThe average age:");
        System.out.println(students.getAverageAgeStream());

        System.out.println("\nConverted list to HashMap:");
        System.out.println(students.convertToMapStream().getStudentsMap());

        System.out.println("\nSet that contains students with id more then 100");
        System.out.println(students.filterMapByIdStream().getStudentsMapFiltered());
    }


}
