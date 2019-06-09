package model;

import java.util.Comparator;

/**
 * Created by aleksey.dobrovolsky on 6/9/2019.
 */
public class Rate {

    private double mbPerMonth;
    private double minPerMonth;
    private double subscriptionFee;
    private double mbCost;
    private double minCost;
    private int clientCount;
    private String rateName;

    public String getRateName() {
        return rateName;
    }

    public void setRateName(String rateName) {
        this.rateName = rateName;
    }

    public double getMbPerMonth() {
        return mbPerMonth;
    }

    public void setMbPerMonth(double mbPerMonth) {
        this.mbPerMonth = mbPerMonth;
    }

    public double getMinPerMonth() {
        return minPerMonth;
    }

    public void setMinPerMonth(double minPerMonth) {
        this.minPerMonth = minPerMonth;
    }

    public double getSubscriptionFee() {
        return subscriptionFee;
    }

    public void setSubscriptionFee(double subscriptionFee) {
        this.subscriptionFee = subscriptionFee;
    }

    public double getMbCost() {
        return mbCost;
    }

    public void setMbCost(double mbCost) {
        this.mbCost = mbCost;
    }

    public double getMinCost() {
        return minCost;
    }

    public void setMinCost(double minCost) {
        this.minCost = minCost;
    }

    public int getClientCount() {
        return clientCount;
    }

    public void setClientCount(int clientCount) {
        this.clientCount = clientCount;
    }

    public static Comparator<Rate> subscriptionFeeComparator = (o1, o2) -> (int) (o1.getSubscriptionFee() - o2.getSubscriptionFee());
}
