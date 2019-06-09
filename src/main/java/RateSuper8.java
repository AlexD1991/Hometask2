/**
 * Created by aleksey.dobrovolsky on 6/9/2019.
 */
public class RateSuper8 extends Rate{

    public RateSuper8(){
        this.setClientCount(2500);
        this.setMbCost(0.9);
        this.setMbPerMonth(200);
        this.setSubscriptionFee(21);
        this.setRateName("Super 8");
        this.setMinCost(0.06);
        this.setMinPerMonth(1000);
    }
}
