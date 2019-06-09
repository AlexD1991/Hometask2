package controller;

import model.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Created by aleksey.dobrovolsky on 6/9/2019.
 */
public class RateList {

    private static ArrayList<Rate> rateList = createRateList();
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    private static Properties p = new Properties();

    private static FileReader readProperties() throws FileNotFoundException {
        return new FileReader(System.getProperty("user.dir") + "/src/main/resources/rateFilterData");
    }

    public static void run() throws IOException {
        System.out.println("Initial list of rates:");
        controller.RateList.printList(rateList);

        System.out.println("\nSorted by Subscription fee rate list:");
        controller.RateList.printList(controller.RateList.sortBySubscriptionFee(rateList));

        System.out.println("\nFiltered by the specified condition rate list:");
        controller.RateList.printList(controller.RateList.filter(rateList));
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

    private static ArrayList<Rate> filter(ArrayList<Rate> list) throws IOException {
        p.load(readProperties());
        double minMbPerMonth = ((!p.getProperty("minMbPerMonth").isEmpty() ? Double.parseDouble(p.getProperty("minMbPerMonth")) : 0));
        double minMinPerMonth = ((!p.getProperty("minMinPerMonth").isEmpty() ? Double.parseDouble(p.getProperty("minMinPerMonth")) : 0));
        double maxSubscriptionFee = ((!p.getProperty("maxSubscriptionFee").isEmpty() ? Double.parseDouble(p.getProperty("maxSubscriptionFee")) : 999999));
        double maxMbCost = ((!p.getProperty("maxMbCost").isEmpty() ? Double.parseDouble(p.getProperty("maxMbCost")) : 999999));
        double maxMinCost = ((!p.getProperty("maxMinCost").isEmpty() ? Double.parseDouble(p.getProperty("maxMinCost")) : 999999));

        return new ArrayList<Rate>(list.stream().filter((x) -> x.getMbPerMonth() >= minMbPerMonth
                && x.getMinPerMonth() >= minMinPerMonth
                && x.getSubscriptionFee() <= maxSubscriptionFee
                && x.getMbCost() <= maxMbCost
                && x.getMinCost() <= maxMinCost).collect(Collectors.toList()));

    }

}
