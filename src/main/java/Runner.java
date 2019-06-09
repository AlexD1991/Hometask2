import java.util.ArrayList;

/**
 * Created by aleksey.dobrovolsky on 6/2/2019.
 */
public class Runner {

    public static void main(String args[]) {

        RateList rateList = new RateList();
        ArrayList<Rate> list = rateList.getRateList();
        RateList.printList(list);

        RateList.printList(RateList.sortBySubscriptionFee(list));

//        System.out.println("Task 2 - Operations with collection:");
//        StudentsOperationsClassic.run();
//
//        System.out.println("Task 3 - Operations with collection using stream api:");
//        StudentsOperationsStream.run();
//
//        System.out.println("Task 4 - Different implementations of List speed comparison  :");
//        Lists.compare();
    }
}
