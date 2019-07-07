package model;

/**
 * Created by aleksey.dobrovolsky on 6/9/2019.
 */
class RateUltra extends Rate {

    RateUltra() {
        this.setClientCount(525);
        this.setMbCost(1);
        this.setMbPerMonth(500);
        this.setSubscriptionFee(23);
        this.setRateName("Ultra");
        this.setMinCost(0.2);
        this.setMinPerMonth(1200);
    }
}
