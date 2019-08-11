package model.rates;

import java.util.Comparator;

/**
 * Created by aleksey.dobrovolsky on 6/9/2019.
 */
public class Rate implements RateInterface {

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

    static Comparator<Rate> subscriptionFeeComparator = (o1, o2) -> (int) (o1.getSubscriptionFee() - o2.getSubscriptionFee());

    public double getMbPerMonth() {
        return mbPerMonth;
    }

    public void setRateName(String rateName) {
        this.rateName = rateName;
    }

    public double getMinPerMonth() {
        return minPerMonth;
    }

    public void setMbPerMonth(double mbPerMonth) {
        this.mbPerMonth = mbPerMonth;
    }

    public double getSubscriptionFee() {
        return subscriptionFee;
    }

    public void setMinPerMonth(double minPerMonth) {
        this.minPerMonth = minPerMonth;
    }

    public double getMbCost() {
        return mbCost;
    }

    public void setSubscriptionFee(double subscriptionFee) {
        this.subscriptionFee = subscriptionFee;
    }

    public double getMinCost() {
        return minCost;
    }

    public void setMbCost(double mbCost) {
        this.mbCost = mbCost;
    }

    public int getClientCount() {
        return clientCount;
    }

    public void setMinCost(double minCost) {
        this.minCost = minCost;
    }

    public void setClientCount(int clientCount) {
        this.clientCount = clientCount;
    }
}
