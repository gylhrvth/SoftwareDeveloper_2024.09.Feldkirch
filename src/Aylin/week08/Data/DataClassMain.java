package Aylin.week08.Data;

import java.util.Arrays;

public class DataClassMain {
    public static void main(String[] args) {
        int[] arr = {36, 59, 2, 79, 27,89,9};

        System.out.println(Arrays.toString(arr));
        DataClass dc = DataClass.getMinMaxAvrg(arr);
        System.out.printf("Min: %d, Max: %d, Avrg: %.2f\n", dc.getMin(), dc.getMax(), dc.getAvrg());
    }
}
