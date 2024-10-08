package Gyula.week05;

import Gyula.WildColors;

public class FourInRow {
    public static void main(String[] args) {
        int[][] field = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
        };
        addStone(field, 1, 1);
        printGameField(field);
    }

    public static void addStone(int[][] field, int column, int player) {
        int i = 0;
        boolean found = false;
        if (column >= 0 && column < field.length) {
            while (i < field[column].length && !found) {
                if (field[column][i] == 0) {
                    field[column][i] = player;
                    found = true;
                }
                ++i;
            }
        }
    }

    public static String[] emptyField = new String[]{
            "@@@@@@@@@@@@@@",
            "@@@@@%+++#@@@@",
            "@@@+.     .=@@",
            "@@+         =@",
            "@@+         =@",
            "@@@+.      =@@",
            "@@@@@#***#@@@@",
            "@@@@@@@@@@@@@@"
    };

    public static String player1Color = WildColors.getColorFromHSL(0, 0.9, 0.5);
    public static String[] player1 = new String[]{
            "@@@@@@@@@@@@@@",
            "@@@@@%+++#@@@@",
            "@@@+." + player1Color + "@@@@@" + WildColors.resetColor() + ".=@@",
            "@@+ " + player1Color + "@@@@@@@" + WildColors.resetColor() + " =@",
            "@@+ " + player1Color + "@@@@@@@" + WildColors.resetColor() + " =@",
            "@@@+." + player1Color + "@@@@@" + WildColors.resetColor() + " =@@",
            "@@@@@#***#@@@@",
            "@@@@@@@@@@@@@@"
    };

    public static String player2Color = WildColors.getColorFromHSL(240, 0.9, 0.5);
    public static String[] player2 = new String[]{
            "@@@@@@@@@@@@@@",
            "@@@@@%+++#@@@@",
            "@@@+." + player2Color + "@@@@@" + WildColors.resetColor() + ".=@@",
            "@@+ " + player2Color + "@@@@@@@" + WildColors.resetColor() + " =@",
            "@@+ " + player2Color + "@@@@@@@" + WildColors.resetColor() + " =@",
            "@@@+." + player2Color + "@@@@@" + WildColors.resetColor() + " =@@",

            "@@@@@#***#@@@@",
            "@@@@@@@@@@@@@@"
    };

    public static void printGameField(int[][] field) {
        for (int j = field[0].length - 1; j >= 0; j--) {
            for (int rowOnImage = 0; rowOnImage < emptyField.length; rowOnImage++) {
                for (int i = 0; i < field.length; i++) {
                    if (field[i][j] == 1) {
                        System.out.print(player1[rowOnImage]);
                    } else if (field[i][j] == 2) {
                        System.out.print(player2[rowOnImage]);
                    } else {
                        System.out.print(emptyField[rowOnImage]);
                    }
                }
                System.out.println();
            }
        }
    }
}
