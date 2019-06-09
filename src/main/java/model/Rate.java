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

    void setRateName(String rateName) {
        this.rateName = rateName;
    }

    public double getMbPerMonth() {
        return mbPerMonth;
    }

    void setMbPerMonth(double mbPerMonth) {
        this.mbPerMonth = mbPerMonth;
    }

    public double getMinPerMonth() {
        return minPerMonth;
    }

    void setMinPerMonth(double minPerMonth) {
        this.minPerMonth = minPerMonth;
    }

    public double getSubscriptionFee() {
        return subscriptionFee;
    }

    void setSubscriptionFee(double subscriptionFee) {
        this.subscriptionFee = subscriptionFee;
    }

    public double getMbCost() {
        return mbCost;
    }

    void setMbCost(double mbCost) {
        this.mbCost = mbCost;
    }

    public double getMinCost() {
        return minCost;
    }

    void setMinCost(double minCost) {
        this.minCost = minCost;
    }

    public int getClientCount() {
        return clientCount;
    }

    void setClientCount(int clientCount) {
        this.clientCount = clientCount;
    }

    public static Comparator<Rate> subscriptionFeeComparator = (o1, o2) -> (int) (o1.getSubscriptionFee() - o2.getSubscriptionFee());
}
