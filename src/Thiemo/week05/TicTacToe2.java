package Thiemo.week05;
/*
 ToDo:
*1  Wie Speichere ich meine Daten? Representation           !!
*2  Spielfeld initialisieren int [3][3] mit 0 gefüllt       !!
*3  Spielfeld ausdrucken                                    !!
*4  Spieler wechseln
*5  UserInput lesen
*6  Feld Belegen
*7  Prüfen ob das Feld leer ist
*8  Win condition prüfen

*/
public class TicTacToe2 {
    public static void main(String[] args) {
        int [][] board = new int[3][3];
        printboard(board);


    }
    public static void printboard(int[][] board){

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1){
                    System.out.print("X");
                } else if (board[i][j] == 2) {
                    System.out.print("O");
                }
                System.out.print((i * 3) + j + 1);
//                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
