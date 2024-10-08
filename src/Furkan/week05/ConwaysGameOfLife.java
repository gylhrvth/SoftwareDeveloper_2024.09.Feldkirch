package Furkan.week05;

/*
ToDo:
1: Repräsentation der Daten
2: Print
3: Anzahl Nachbarn
4: Generieren neue Generationen
 */


import Sandro.Colors;

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
    int [][] field = GLEITER;
    printField(field);



    }


    public static void printField(int [][] field){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == 1){
                    System.out.print(Colors.BACKGROUND_COLORS[5] + "  " + Colors.RESET);
                }else {
                    System.out.print(Colors.BACKGROUND_COLORS[4] + "  " + Colors.RESET);
                }
            }
            System.out.println();
        }





    }




}
