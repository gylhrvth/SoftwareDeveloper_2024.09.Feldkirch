package Sandro.Week4;

public class Pascal {

    public static void main(String[] args) {
        int size = 14;
        int[][] test = createPascal(size);
        printArray(test, size);
    }
    public static int[][] createPascal(int size) {

        int[][] array = new int[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == 0 || j == 0) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = array[i - 1][j] + array[i][j - 1];                     //aktelle zahl = links + oben
                }
            }
        }
        return array;
    }
    public static void printArray(int[][] arr, int size) {

        int space = findBiggestNumber(size)+3;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%"+space+"d ", arr[i][j]);
            }
            System.out.println();
        }


    }

    public static int findBiggestNumber (int size){
        int value = 0;
        int [][] test = createPascal(size);
        int bignumber = test[size-1][size-1];
        String tempValue = String.valueOf(bignumber);
        value =tempValue.length();
        return value;
    }

}
