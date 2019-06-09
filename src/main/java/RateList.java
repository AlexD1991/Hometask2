import java.util.ArrayList;

/**
 * Created by aleksey.dobrovolsky on 6/9/2019.
 */
public class RateList {

    private ArrayList<Rate> rateList = createRateList();

    public ArrayList<Rate> getRateList() {
        return rateList;
    }

    public void setRateList(ArrayList<Rate> rateList) {
        this.rateList = rateList;
    }

    private ArrayList<Rate> createRateList(){
        ArrayList<Rate> list = new ArrayList<>();
        list.add(new Rate4G());
        list.add(new RateSuper8());
        list.add(new RateUltra());
        list.add(new RateInternetMax());
        list.add(new RateInternetMin());
        return list;

    }

    public int getClientCount(){
        return rateList.stream().mapToInt(Rate::getClientCount).sum();
    }

    static void printList(ArrayList<Rate> list){
        System.out.println(String.format("\n%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s",
                "Rate name",
                "Subscription",
                "MB per month",
                "Min per month",
                "Cost for 1 MB",
                "Cost for 1 min",
                "Clients count"));
        for (Rate item : list){
            System.out.println(String.format("%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s",
                    item.getRateName(),
                    item.getSubscriptionFee(),
                    item.getMbPerMonth(),
                    item.getMinPerMonth(),
                    item.getMbCost(),
                    item.getMinCost(),
                    item.getClientCount()));
        }
    }

    static ArrayList<Rate> sortBySubscriptionFee(ArrayList<Rate> list){
        list.sort(Rate.subscriptionFeeComparator);
        return list;
    }

}
