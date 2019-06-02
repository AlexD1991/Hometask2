import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by aleksey.dobrovolsky on 6/2/2019.
 */
class Lists {

    private static ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private static LinkedList<Integer> linkedList = new LinkedList<Integer>();

    static void compare() {
        init();
        int elementToSearch = arrayList.get(5000000);
        displayResult(getTimeAdd(arrayList), getTimeAdd(linkedList), "Add elements");
        displayResult(getTimeRemove(arrayList), getTimeRemove(linkedList), "Remove elements");
        displayResult(getTimeSearch(arrayList, elementToSearch), getTimeSearch(linkedList, elementToSearch), "Search elements");
    }

    private static void init() {
        fillList(arrayList);
        fillList(linkedList);
    }

    private static void displayResult(long arrayListResult, long linkedListResult, String header) {
        System.out.println(header);
        System.out.println(String.format("Result of ArrayList - %s ms", arrayListResult));
        System.out.println(String.format("Result of LinkedList - %s ms", linkedListResult));
        if (arrayListResult > linkedListResult)
            System.out.println(String.format("LinkedList operation is faster then ArrayList one on %s ms\n", arrayListResult - linkedListResult));
        else
            System.out.println(String.format("ArrayList operation is faster then LinkedList one on %s ms\n", linkedListResult - arrayListResult));
    }

    private static long getTimeAdd(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        addElementsToList(list, 1000, 1);
        return System.currentTimeMillis() - startTime;
    }

    private static long getTimeRemove(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        removeElements(list, 1000);
        return System.currentTimeMillis() - startTime;
    }

    private static long getTimeSearch(List<Integer> list, int elementToSearch) {
        long startTime = System.currentTimeMillis();
        searchElementsSomeTimes(list, 1000, elementToSearch);
        return System.currentTimeMillis() - startTime;
    }


    private static void fillList(Collection<Integer> list) {
        int value;
        for (int i = 0; i < 10000000; i++) {
            value = (int) (Math.random() * 10000);
            list.add(value);
        }
    }

    private static void addElementsToList(Collection<Integer> list, int count, int value) {
        for (int i = 0; i < count; i++) {
            list.add(value);
        }
    }

    private static void removeElements(List<Integer> list, int count) {
        for (int i = 0; i < count; i++) {
            list.remove(0);
        }
    }

    private static int searchElement(List<Integer> list, int element) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == element) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static void searchElementsSomeTimes(List<Integer> list, int count, int element) {
        for (int i = 0; i < count; i++) {
            searchElement(list, element);
        }
    }


}
