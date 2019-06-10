package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.IntConsumer;

/**
 * Created by aleksey.dobrovolsky on 6/2/2019.
 */
public class Lists {

    private static ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private static LinkedList<Integer> linkedList = new LinkedList<Integer>();

    public static void compare() {
        init();
        int elementToSearch = arrayList.get(5000000);
        displayResult(getTime(l -> addElementsToList(arrayList, 1000, 123)), getTime(l -> addElementsToList(linkedList, 1000, 123)), "Add elements");
        displayResult(getTime(l -> removeElements(arrayList, 1000)), getTime(l -> removeElements(linkedList, 1000)), "Remove elements");
        displayResult(getTime(l -> searchElementsSomeTimes(arrayList, 100, elementToSearch)), getTime(l -> searchElementsSomeTimes(linkedList, 100, elementToSearch)), "Search elements (100)");
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

    private static long getTime(IntConsumer aMethod){
        long startTime = System.currentTimeMillis();
        aMethod.accept(0);
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
