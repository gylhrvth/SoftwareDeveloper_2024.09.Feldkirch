package Gyula.week03;

import java.util.Arrays;

public class ArrayAsFunctionParameter {
    public static void main(String[] args) {
        int a = 5;
        int[] arr = new int[1];
        arr[0] = 5;

        System.out.println(a + " " + Arrays.toString(arr));
        doSomething(a, arr);
        System.out.println(a + " " + Arrays.toString(arr));
    }


    public static void doSomething(int a, int[] arr){
        ++a;
        ++arr[0];
    }
}
