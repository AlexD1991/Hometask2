package model;

import model.Rate;

/**
 * Created by aleksey.dobrovolsky on 6/9/2019.
 */
public class RateSuper8 extends Rate {

    private int discount = 15;

    public RateSuper8() {
        this.setClientCount(2500);
        this.setMbCost(0.9);
        this.setMbPerMonth(200);
        this.setSubscriptionFee(21);
        this.setRateName("Super 8");
        this.setMinCost(0.06);
        this.setMinPerMonth(1000);
    }

    public double getSubscriptionFee() {
        return super.getSubscriptionFee() * (100 - discount) / 100;
    }
}
