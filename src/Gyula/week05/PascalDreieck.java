package Gyula.week05;

public class PascalDreieck {
    public static void main(String[] args) {
        int size = Gyula.ConsoleTools.readNumber("Wie groß ist der Dreieck?", 1, 15);
        int[][] arr = createPascalTriangle(size);
        print2DArray(arr);
    }

    public static int[][] createPascalTriangle(int size){
        int[][] arr = new int[size][size];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i > 0 && j > 0){
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                } else {
                    arr[i][j] = 1;
                }
            }
        }
        return arr;
    }

    public static void print2DArray(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%5d ", arr[i][j]);
            }
            System.out.println();
        }
    }
}
