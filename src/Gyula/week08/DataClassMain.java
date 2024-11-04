package Gyula.week08;

import Gyula.week03.RandomNumbers;

import java.util.Arrays;

public class DataClassMain {
    public static void main(String[] args) {
        int[] arr = RandomNumbers.createRandomArray(20);
        System.out.println(Arrays.toString(arr));

        DataClass dc = DataClass.getMinMaxAvg(arr);
        System.out.printf(
                "Min: %d, Max: %d, Avg: %.2f\n",
                dc.getMin(),
                dc.getMax(),
                dc.getAvrg());
    }
}
