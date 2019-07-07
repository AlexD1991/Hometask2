package model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by aleksey.dobrovolsky on 7/7/2019.
 */
class RateListFilterProperties {

    private static Properties p = new Properties();
    private final String resourceFileName = "rateFilterData";
    private double minMbPerMonth = 0;
    private double minMinPerMonth = 0;
    private double maxSubscriptionFee = 999999;
    private double maxMbCost = 999999;
    private double maxMinCost = 999999;

    RateListFilterProperties() throws IOException {
        setProperties();
    }

    private static boolean isPresent(String propertyName){
        return p.getProperty(propertyName) != null;
    }

    double getMinMbPerMonth() {
        return minMbPerMonth;
    }

    double getMinMinPerMonth() {
        return minMinPerMonth;
    }

    double getMaxSubscriptionFee() {
        return maxSubscriptionFee;
    }

    double getMaxMbCost() {
        return maxMbCost;
    }

    double getMaxMinCost() {
        return maxMinCost;
    }

    private InputStream readProperties() {
        return RateListFilterProperties.class
                .getResourceAsStream("/"+resourceFileName);
    }

    private void setProperties() throws IOException {
        try {
            p.load(readProperties());
        } catch (NullPointerException e){
            System.out.println("File "+ resourceFileName +" cannot be found in resources. Default filter values will be set.");
        }

        if (isPresent("minMbPerMonth"))
            minMbPerMonth = ((!p.getProperty("minMbPerMonth").isEmpty() ? Double.parseDouble(p.getProperty("minMbPerMonth")) : 0));
        if (isPresent("minMinPerMonth"))
            minMinPerMonth = ((!p.getProperty("minMinPerMonth").isEmpty() ? Double.parseDouble(p.getProperty("minMinPerMonth")) : 0));
        if (isPresent("maxSubscriptionFee"))
            maxSubscriptionFee = ((!p.getProperty("maxSubscriptionFee").isEmpty() ? Double.parseDouble(p.getProperty("maxSubscriptionFee")) : 999999));
        if (isPresent("maxMbCost"))
            maxMbCost = ((!p.getProperty("maxMbCost").isEmpty() ? Double.parseDouble(p.getProperty("maxMbCost")) : 999999));
        if (isPresent("maxMinCost"))
            maxMinCost = ((!p.getProperty("maxMinCost").isEmpty() ? Double.parseDouble(p.getProperty("maxMinCost")) : 999999));
        printFilterData();
    }

    private void printFilterData(){
        System.out.println("\nFiltering by the following conditions:");
        System.out.println(String.format("Maximum subscription fee - %s\n" +
                "Minimum MB per month - %s\n" +
                "Minimum minutes per month - %s\n" +
                "Maximum MB cost - %s\n" +
                "Maximum minute cost - %s",
                maxSubscriptionFee,
                minMbPerMonth,
                minMinPerMonth,
                maxMbCost,
                maxMinCost));
    }

}
