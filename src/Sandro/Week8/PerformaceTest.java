package Sandro.Week8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class PerformaceTest {

    private static final int FILLS_FOR_END = 100000000;
    private static final int FILLS_FOR_START = 100000;

    private static final int FILLS_FOR_START_REMOVE = 300000;
    private static final int FILLS_FOR_END_REMOVE = 300000;

    private static final int FILLS_FOR_CENTER_REMOVE = 300000;
    private static final int FILL_VALUE = 10;

    public static void main(String[] args) {
        System.out.println("---FILL AT END: " + FILLS_FOR_END + " elements---");
        System.out.println("ArrayList: " + measure(() -> fillAtEnd(new ArrayList<>(), FILL_VALUE, FILLS_FOR_END)) + " ms");
        System.out.println("LinkedList: " + measure(() -> fillAtEnd(new LinkedList<>(), FILL_VALUE, FILLS_FOR_END)) + "ms");
        System.out.println("Vector: " + measure(() -> fillAtEnd(new java.util.Vector<>(), FILL_VALUE, FILLS_FOR_END)) + " ms");

        System.out.println("---FILL AT START: " + FILLS_FOR_START + " elements---");
        System.out.println("ArrayList: " + measure(() -> fillAtStart(new ArrayList<>(), FILL_VALUE, FILLS_FOR_START)) + " ms");
        System.out.println("LinkedList: " + measure(() -> fillAtStart(new LinkedList<>(), FILL_VALUE, FILLS_FOR_START)) + "ms");
        System.out.println("Vector: " + measure(() -> fillAtStart(new java.util.Vector<>(), FILL_VALUE, FILLS_FOR_START)) + " ms");

        System.out.println("---REMOVE FROM START: " + FILLS_FOR_START_REMOVE + " elements---");
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> vector = new Vector<>();
        List<Integer> linkedList = new LinkedList<>();
        fillAtStart(arrayList, FILL_VALUE, FILLS_FOR_START_REMOVE);
        fillAtStart(vector, FILL_VALUE, FILLS_FOR_START_REMOVE);
        fillAtStart(linkedList, FILL_VALUE, FILLS_FOR_START_REMOVE);
        System.out.println("ArrayList: " + measure(() -> removeFromStart(arrayList)) + " ms");
        System.out.println("LinkedList: " + measure(() -> removeFromStart(linkedList)) + "ms");
        System.out.println("Vector: " + measure(() -> removeFromStart(vector)) + " ms");

        System.out.println("---REMOVE FROM END: " + FILLS_FOR_END_REMOVE + " elements---");
        arrayList.clear();
        vector.clear();
        linkedList.clear();
        fillAtStart(arrayList, FILL_VALUE, FILLS_FOR_END_REMOVE);
        fillAtStart(vector, FILL_VALUE, FILLS_FOR_END_REMOVE);
        fillAtStart(linkedList, FILL_VALUE, FILLS_FOR_END_REMOVE);
        System.out.println("ArrayList: " + measure(() -> removeFromEnd(arrayList)) + " ms");
        System.out.println("LinkedList: " + measure(() -> removeFromEnd(linkedList)) + "ms");
        System.out.println("Vector: " + measure(() -> removeFromEnd(vector)) + " ms");

        System.out.println("---REMOVE FROM CENTER: " + FILLS_FOR_CENTER_REMOVE + " elements---");
        arrayList.clear();
        vector.clear();
        linkedList.clear();
        fillAtStart(arrayList, FILL_VALUE, FILLS_FOR_CENTER_REMOVE);
        fillAtStart(vector, FILL_VALUE, FILLS_FOR_CENTER_REMOVE);
        fillAtStart(linkedList, FILL_VALUE, FILLS_FOR_CENTER_REMOVE);
        System.out.println("ArrayList: " + measure(() -> removeFromCenter(arrayList)) + " ms");
        System.out.println("LinkedList: " + measure(() -> removeFromCenter(linkedList)) + "ms");
        System.out.println("Vector: " + measure(() -> removeFromCenter(vector)) + " ms");
    }

    private static long measure(Runnable runnable) {
        long start = System.currentTimeMillis();
        runnable.run();
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static void fillAtEnd(List<Integer> list, int value, int amount) {
        for (int i = 0; i < amount; i++) {
            list.add(value);
        }
    }

    private static void fillAtStart(List<Integer> list, int value, int amount) {
        for (int i = 0; i < amount; i++) {
            list.add(0, value);
        }
    }

    private static void removeFromStart(List<Integer> list) {
        while (list.size() > 0) {
            list.remove(0);
        }
    }

    private static void removeFromEnd(List<Integer> list) {
        while (list.size() > 0) {
            list.remove(list.size() - 1);
        }
    }

    private static void removeFromCenter(List<Integer> list) {
        while (list.size() > 0) {
            list.remove(list.size() / 2);
        }
    }
}
