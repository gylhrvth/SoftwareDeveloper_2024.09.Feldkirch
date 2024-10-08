package Erik.week05;

/*
        Todo:   1. Representation der Daten. (Spielbrett ist leer definiert mit "0" => Leer = 0)
                2. Erstellung des Arrays [6][7] 6 Reihen, 7 Spalten
                3. Spielfeld Printen
                4. User Input einlesen.
                5. Stein legen, bzw Spielzug ausführen.
                6. Win Condition machen.
                7. Draw Situation machen.
------------------------------------------------------------------------------------------------------------------------
     Probleme:  1.
                2.
 */

public class VierGewinnt {
    public static void main(String[] args) {

        int[][]gameField = generateGameField();



    }

    public static int[][] generateGameField() {
        int[][] field = new int[6][7];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = 0;
            }
        }
        return field;
    }

}
