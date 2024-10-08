package Thiemo.week05;


/*
 ToDo:
*1  Wie Speichere ich meine Daten? Representation
*2  feld initialisieren int [x][X] mit 0 gefüllt
*4  Feld ausdrucken
*5  Anzahl Nachbarn
*6  New Generation generieren

*/

public class ConwaysGameOfLife {

    public static final int[][] GLEITER = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };


    public static void main(String[] args) {
        int[][] field = GLEITER;

        int Generations = 20;
        for (int i = 0; i < Generations; i++) {

            printfield(field);
            field = nextGen(field);
        }
    }

    public static int countNeigboursHardWall(int[][] field, int x, int y) {
        int count = 0;
        int rows = field.length;
        int cols = field[0].length;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0)) {
                    int newX = x + i;
                    int newY = y + j;

                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                        count += field[newX][newY];
                    }
                }
            }
        }
        return count;
    }

    public static int countNeighboursRoundUp(int[][] field,int x,int y) {

        int count = 0;
        int rows = field.length;
        int cols = field[0].length;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0)) {
                    int newX = (x + i + rows) % rows;
                    int newY = (y + j + cols) % cols;

                        count += field[newX][newY];
                }
            }
        }
        return count;
    }

    public static int[][] nextGen(int[][] field) {

        int rows = field.length;
        int cols = field[0].length;
        int[][] newField = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbours = countNeighboursRoundUp(field, i, j);

                if (field[i][j] == 1) {
                    if (liveNeighbours < 2 || liveNeighbours > 3) {
                        newField[i][j] = 0;
                    } else {
                        newField[i][j] = 1;
                    }
                } else {
                    if (liveNeighbours == 3) {
                        newField[i][j] = 1;
                    }
                }
            }
        }
        return newField;
    }

    public static void printfield(int[][] field) {

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == 1) {
                    System.out.print("@");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}