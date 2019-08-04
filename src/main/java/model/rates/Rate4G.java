package model.rates;

/**
 * Created by aleksey.dobrovolsky on 6/9/2019.
 */
class Rate4G extends Rate {

    Rate4G() {
        this.setClientCount(120);
        this.setMbCost(0.7);
        this.setMbPerMonth(100);
        this.setSubscriptionFee(20);
        this.setRateName("4G");
        this.setMinCost(0.05);
        this.setMinPerMonth(500);
    }
}
