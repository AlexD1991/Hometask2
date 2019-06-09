package model;

/**
 * Created by aleksey.dobrovolsky on 6/9/2019.
 */
public class RateInternetMax extends RateOnlyInternet {

    public RateInternetMax(){
        this.setClientCount(200);
        this.setMbCost(0.1);
        this.setMbPerMonth(20000);
        this.setSubscriptionFee(15);
        this.setRateName("Internet Max");
    }
}
