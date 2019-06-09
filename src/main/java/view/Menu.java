package view;

import controller.Lists;
import controller.RateList;
import controller.StudentsOperationsClassic;
import controller.StudentsOperationsStream;
import model.Rate;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by aleksey.dobrovolsky on 6/2/2019.
 */
public class Menu {

    public static void main(String args[]) throws IOException {

        Scanner in = new Scanner(System.in);
        String input;

        do {
            do {
                System.out.println("Select task number to execute:" +
                        "\n1. Mobile rates hierarchy" +
                        "\n2. Operations with collection" +
                        "\n3. Operations with collection using stream api" +
                        "\n4. Speed comparison of different implementations of List" +
                        "\n5. Exit");
                input = in.nextLine();

                switch (input) {
                    case "1":
                        RateList.run();
                        break;
                    case "2":
                        StudentsOperationsClassic.run();
                        break;
                    case "3":
                        StudentsOperationsStream.run();
                        break;
                    case "4":
                        Lists.compare();
                        break;
                    case "5":
                        break;
                }
                if (Objects.equals(input, "5")) break;

                System.out.println("Exit? y/n");
                input = in.nextLine();
            } while (!Objects.equals(input, "y"));
            if (Objects.equals(input, "y")) break;
        } while (!Objects.equals(input, "5"));
    }
}
