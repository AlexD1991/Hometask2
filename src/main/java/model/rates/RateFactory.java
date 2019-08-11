package model.rates;

class RateFactory {

    Rate getRate(RateTypes type) {
        Rate toReturn = null;
        switch (type) {
            case _4G:
                toReturn = new Rate4G();
                break;
            case ULTRA:
                toReturn = new RateUltra();
                break;
            case SUPER_8:
                toReturn = new RateSuper8();
                break;
            case INTERNET_MIN:
                toReturn = new RateInternetMin();
                break;
            case INTERNET_MAX:
                toReturn = new RateInternetMax();
                break;
            default:
                throw new IllegalArgumentException("Wrong rate type:" + type);
        }
        return toReturn;
    }
}
