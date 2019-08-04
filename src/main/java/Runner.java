import model.lists.Lists;
import model.rates.RateListRunner;
import model.students.StudentsListRunner;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by aleksey.dobrovolsky on 6/2/2019.
 */
public class Runner {

    public static void main(String args[]) throws IOException {

        Scanner in = new Scanner(System.in);
        String input;

        do {
            System.out.println("\nSelect task number to execute:" +
                    "\n1. Mobile rates hierarchy" +
                    "\n2. Operations with collection" +
                    "\n3. Operations with collection using stream api" +
                    "\n4. Speed comparison of different implementations of List" +
                    "\n5. Exit");
            input = in.nextLine();

            switch (input) {
                case "1":
                    System.out.println("\n1. Mobile rates hierarchy task result");
                    new RateListRunner().run();
                    break;
                case "2":
                    System.out.println("\n2. Operations with collection task result");
                    new StudentsListRunner().runClassic();
                    break;
                case "3":
                    System.out.println("\n3. Operations with collection using stream api task result");
                    new StudentsListRunner().runStream();
                    break;
                case "4":
                    System.out.println("\n4. Speed comparison of different implementations of List task result");
                    Lists.compare();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (!Objects.equals(input, "5"));
    }
}
