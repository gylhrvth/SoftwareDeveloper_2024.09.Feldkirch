package Gyula.week03;

public class ForIvsForEach {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 2, 1, 5, 6, 7, 0};

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println();

        for (int value : arr){
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println();

    }
}
