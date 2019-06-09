package model;

import model.Rate;

/**
 * Created by aleksey.dobrovolsky on 6/9/2019.
 */
class RateOnlyInternet extends Rate {

    RateOnlyInternet(){
        this.setMinPerMonth(0);
        this.setMinCost(999999);
    }
}
