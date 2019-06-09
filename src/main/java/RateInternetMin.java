/**
 * Created by aleksey.dobrovolsky on 6/9/2019.
 */
public class RateInternetMin extends RateOnlyInternet {

    RateInternetMin(){
        this.setClientCount(300);
        this.setMbCost(0.05);
        this.setMbPerMonth(500);
        this.setSubscriptionFee(10);
        this.setRateName("Internet Min");
    }
}
