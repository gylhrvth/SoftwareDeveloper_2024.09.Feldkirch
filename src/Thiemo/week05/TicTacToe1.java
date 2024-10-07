package Thiemo.week05;

/*
 ToDo:
*1  Wie Speichere ich meine Daten? Representation       ??
*2  Spielfeld initialisieren int [3][3] mit 0 gefüllt   !!
*3  Spielfeld ausdrucken                                !!
*4  Spieler wechseln
*5  UserInput lesen                                     !!
*6  Feld Belegen
*7  Prüfen ob das Feld leer ist
*8  Win condition prüfen

*/

public class TicTacToe1 {
    public static void main(String[] args) {

        int [][] board = createBoard();
        printboard(board);

    }
    public static int[][] createBoard(){
        int [][] board = new int[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 0;
            }
        }
        return board;
    }
    public static void printboard(int [][] board){
        System.out.println("\n");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.printf("%7d",board[i][j]);

            }
            System.out.println("\n");
        }
    }
}


