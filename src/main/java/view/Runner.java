package view;

import controller.RateList;
import controller.StudentsOperationsClassic;
import controller.StudentsOperationsStream;
import model.Rate;

import java.util.ArrayList;

/**
 * Created by aleksey.dobrovolsky on 6/2/2019.
 */
public class Runner {

    public static void main(String args[]) {

        System.out.println("Task 1 - Mobile rates hierarchy:");
        RateList.run();

        System.out.println("Task 2 - Operations with collection:");
        StudentsOperationsClassic.run();

        System.out.println("Task 3 - Operations with collection using stream api:");
        StudentsOperationsStream.run();

        System.out.println("Task 4 - Different implementations of List speed comparison  :");
        controller.Lists.compare();
    }
}
