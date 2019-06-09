package controller;

import model.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by aleksey.dobrovolsky on 6/9/2019.
 */
public class RateList {

    private static ArrayList<Rate> rateList = createRateList();
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public static void run(){
        System.out.println("Initial list of rates:");
        controller.RateList.printList(rateList);

        System.out.println("\nSorted by Subscription fee rate list:");
        controller.RateList.printList(controller.RateList.sortBySubscriptionFee(rateList));

        System.out.println("\nFiltered by the specified condition rate list:");
        controller.RateList.printList(controller.RateList.filter(rateList, 20, 100, 500, 0.8, 0.05));
    }

    public ArrayList<Rate> getRateList() {
        return rateList;
    }

    private static ArrayList<Rate> createRateList() {
        ArrayList<Rate> list = new ArrayList<>();
        list.add(new Rate4G());
        list.add(new RateSuper8());
        list.add(new RateUltra());
        list.add(new RateInternetMax());
        list.add(new RateInternetMin());
        return list;

    }

    public int getClientCount() {
        return rateList.stream().mapToInt(Rate::getClientCount).sum();
    }

    private static void printList(ArrayList<Rate> list) {
        System.out.println(String.format("\n%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s",
                "Rate name",
                "Subscription",
                "MB per month",
                "Min per month",
                "Cost for 1 MB",
                "Cost for 1 min",
                "Clients count"));
        for (Rate item : list) {
            System.out.println(String.format("%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s",
                    item.getRateName(),
                    item.getSubscriptionFee(),
                    item.getMbPerMonth(),
                    item.getMinPerMonth(),
                    item.getMbCost(),
                    item.getMinCost(),
                    item.getClientCount()));
        }
    }

    private static ArrayList<Rate> sortBySubscriptionFee(ArrayList<Rate> list) {
        list.sort(Rate.subscriptionFeeComparator);
        return list;
    }

    private static ArrayList<Rate> filter(ArrayList<Rate> list,
                                          double maxSubscriptionFee,
                                          double minMbPerMonth,
                                          double minMinPerMonth,
                                          double maxMbCost,
                                          double maxMinCost) {
         return new ArrayList<Rate>(list.stream().filter((x) -> x.getMbPerMonth() >= minMbPerMonth
                && x.getMinPerMonth() >= minMinPerMonth
                && x.getSubscriptionFee() <= maxSubscriptionFee
                && x.getMbCost() <= maxMbCost
                && x.getMinCost() <= maxMinCost).collect(Collectors.toList()));

    }

}
