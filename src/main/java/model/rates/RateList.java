package model.rates;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static model.rates.RateTypes.*;

/**
 * Created by aleksey.dobrovolsky on 6/9/2019.
 */
public class RateList {

    private static ArrayList<Rate> rateList = new ArrayList<>();
    private static ArrayList<Rate> rateListFiltered = new ArrayList<>();
    RateFactory factory = new RateFactory();

    RateList() {
        createRateList();
    }

    private void createRateList() {
        rateList.add(factory.getRate(_4G));
        rateList.add(factory.getRate(INTERNET_MAX));
        rateList.add(factory.getRate(INTERNET_MIN));
        rateList.add(factory.getRate(SUPER_8));
        rateList.add(factory.getRate(ULTRA));
    }

    void printList() {
        System.out.println(String.format("\n%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s",
                "Rate name",
                "Subscription",
                "MB per month",
                "Min per month",
                "Cost for 1 MB",
                "Cost for 1 min",
                "Clients count"));
        for (Rate item : rateList) {
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

    void printListFiltered() {
        System.out.println(String.format("\n%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s",
                "Rate name",
                "Subscription",
                "MB per month",
                "Min per month",
                "Cost for 1 MB",
                "Cost for 1 min",
                "Clients count"));
        for (Rate item : rateListFiltered) {
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

    RateList sortBySubscriptionFee() {
        rateList.sort(Rate.subscriptionFeeComparator);
        return this;
    }

    RateList filter() throws IOException {

        RateListFilterProperties properties = new RateListFilterProperties();

        rateListFiltered = new ArrayList<Rate>(rateList.stream().filter((x) -> x.getMbPerMonth() >= properties.getMinMbPerMonth()
                && x.getMinPerMonth() >= properties.getMinMinPerMonth()
                && x.getSubscriptionFee() <= properties.getMaxSubscriptionFee()
                && x.getMbCost() <= properties.getMaxMbCost()
                && x.getMinCost() <= properties.getMaxMinCost()).collect(Collectors.toList()));
        return this;

    }

    int getClientCount() {
        return rateList.stream().mapToInt(Rate::getClientCount).sum();
    }

}
