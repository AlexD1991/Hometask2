package model.rates;

public interface RateInterface {
    String getRateName();

    void setRateName(String rateName);

    double getMbPerMonth();

    void setMbPerMonth(double mbPerMonth);

    double getMinPerMonth();

    void setMinPerMonth(double minPerMonth);

    double getSubscriptionFee();

    void setSubscriptionFee(double subscriptionFee);

    double getMbCost();

    void setMbCost(double mbCost);

    double getMinCost();

    void setMinCost(double minCost);

    int getClientCount();

    void setClientCount(int clientCount);
}
