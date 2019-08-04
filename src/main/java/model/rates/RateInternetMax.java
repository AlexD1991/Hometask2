package model.rates;

/**
 * Created by aleksey.dobrovolsky on 6/9/2019.
 */
class RateInternetMax extends RateOnlyInternet {

    RateInternetMax() {
        this.setClientCount(200);
        this.setMbCost(0.1);
        this.setMbPerMonth(20000);
        this.setSubscriptionFee(15);
        this.setRateName("Internet Max");
    }
}
