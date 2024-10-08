package Gyula.week05;

public class GameOfLife {
    public static final int[][] GLEITER = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    public static void main(String[] args) {
        int[][] arr = GLEITER;
        printLife(arr);

        while (true) {
            arr = nextGeneration(arr);
            printLife(arr);

            try {
                Thread.sleep(100);
            } catch (InterruptedException ie){}
        }
    }

    public static int[][] nextGeneration(int[][] prevGen){
        int[][] result = new int[prevGen.length][];
        for (int i = 0; i < prevGen.length; i++) {
            result[i] = new int[prevGen[i].length];
        }

        for (int i = 0; i < prevGen.length; i++) {
            for (int j = 0; j < prevGen[i].length; j++) {
                int countNeigbours = countNeighboursRoundUp(prevGen, i, j);
                if (countNeigbours == 3){
                    result[i][j] = 1;
                } else if (countNeigbours == 2){
                    result[i][j] = prevGen[i][j];
                } else {
                    result[i][j] = 0; // Tot
                }
            }
        }
        return result;
    }

    public static int countNeighboursHardWall(int[][] arr, int row, int col){
        if (row < 0 || row >= arr.length || col < 0 || col >= arr[row].length){
            return 0;
        }
        int sum = -1 * arr[row][col];
        for (int i = row - 1; i < row + 2; i++) {
            for (int j = col -1; j < col + 2; j++) {
                if (i >= 0 && i < arr.length && j >=0 && j < arr[i].length) {
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }

    public static int countNeighboursRoundUp(int[][] arr, int row, int col){
        if (row < 0 || row >= arr.length || col < 0 || col >= arr[row].length){
            return 0;
        }
        int sum = -1 * arr[row][col];
        for (int i = row - 1; i < row + 2; i++) {
            for (int j = col -1; j < col + 2; j++) {
                int rowPos = (i + arr.length) % arr.length;
                int colPos = (j + arr[rowPos].length) % arr[rowPos].length;

                sum += arr[rowPos][colPos];

            }
        }
        return sum;
    }


    public static void printLife(int[][] arr){
        Sandro.Colors.clearScreen();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1){
                    System.out.print("@");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
