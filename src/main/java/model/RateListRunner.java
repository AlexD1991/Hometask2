package model;

import java.io.IOException;

/**
 * Created by aleksey.dobrovolsky on 7/7/2019.
 */
public class RateListRunner {

    private RateList rateList = new RateList();

    public void run() throws IOException {
        System.out.println("Initial list of rates:");
        rateList.printList();

        System.out.println("\nSorted by Subscription fee rate list:");
        rateList.sortBySubscriptionFee().printList();

        System.out.println("\nClients count:");
        System.out.println(rateList.getClientCount());

        System.out.println("\nFiltered by the specified condition rate list:");

        rateList.filter().printListFiltered();
    }
}
