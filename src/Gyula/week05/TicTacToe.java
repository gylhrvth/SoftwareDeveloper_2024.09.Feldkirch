package Gyula.week05;

import Gyula.ConsoleTools;

public class TicTacToe {
    public static void main(String[] args) {
        playTicTacToe();
    }

    public static void playTicTacToe(){
        int[][] field = initTicTacToe();
        int player = 1;

        boolean win = false;
        while (!win && !checkPattSituation(field)) {
            printTicTacToe(field);
            System.out.println("Player " + (player == 1 ? "X":"O") + " macht der nächter Schritt!");
            int userInput = ConsoleTools.readNumber(">>> ", 1, 9);
            int row = (userInput - 1) / 3;
            int column = (userInput - 1) % 3;

            if (field[row][column] == 0) {
                field[row][column] = player;

                if (checkWin(player, field)){
                    win = true;
                } else {
                    if (player == 1) {
                        player = 2;
                    } else {
                        player = 1;
                    }
                }
            } else {
                System.out.println("Die Position ist schon belegt, wähle etwas anderes");
            }
        }
        printTicTacToe(field);
        if (win){
            System.out.println("Player " + (player == 1 ? "X":"O") + " has won the match.");
        } else {
            System.out.println("Niemand hat gewonnen. Es ist ein Patt-Situation.");
        }
    }


    public static boolean checkPattSituation(int[][] field){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 0){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean checkWin(int player, int[][] field){
        // Win horizontal
        if (field[0][0] == player && field[0][1] == player && field[0][2] == player){
            return true;
        }
        if (field[1][0] == player && field[1][1] == player && field[1][2] == player){
            return true;
        }
        if (field[2][0] == player && field[2][1] == player && field[2][2] == player){
            return true;
        }

        // Win vertical
        if (field[0][0] == player && field[1][0] == player && field[2][0] == player){
            return true;
        }
        if (field[0][1] == player && field[1][1] == player && field[2][1] == player){
            return true;
        }
        if (field[0][2] == player && field[1][2] == player && field[2][2] == player){
            return true;
        }

        // Win diagonal
        if (field[0][0] == player && field[1][1] == player && field[2][2] == player){
            return true;
        }
        if (field[0][2] == player && field[1][1] == player && field[2][0] == player){
            return true;
        }
        return false;
    }

    public static void printTicTacToe(int[][] field){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 1){
                    System.out.print("X ");
                } else if (field[i][j] == 2){
                    System.out.print("O ");
                } else {
                    System.out.printf("%d ", 3 * i + j +1);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] initTicTacToe(){
        int[][] field = new int[3][3];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = 0;
            }
        }
        return field;
    }
}
