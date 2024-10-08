package Gyula.week05;

import Gyula.ConsoleTools;

public class TicTacToe2 {
    public static void main(String[] args) {
        int[][] field = createField();
        printField(field);

        for (int turn = 0; turn < 15; turn++) {
            int spieler = 1 + (turn % 2);
            int playerChoiseRow = ConsoleTools.readNumber("Row >>", 0, 2);
            int playerChoiseCol = ConsoleTools.readNumber("Col >>", 0, 2);

            System.out.println("Spieler " + spieler + " move: " + playerChoiseRow + ", " + playerChoiseCol);
            field[playerChoiseRow][playerChoiseCol] = spieler;
            printField(field);
        }

    }

    public static void printField(int[][] field){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] createField(){
        int[][] field = new int[3][3];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = 0;
            }
        }
        return field;
    }
}
