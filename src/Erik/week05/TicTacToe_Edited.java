package Erik.week05;

import Sandro.Colors;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
            Todo:       1. Wie speichere ich meine Daten? Representation. ♥
                        2. Spielfeld Initialisieren [3][3], mit "0". ♥
                        3. Spielfeld ausdrucken. ♥
                        4. Spieler Wechseln. ♥
                        5. User Input einlesen. ♥
                        6. Stein legen bzw. Zug ausspielen. ♥
                        7. Prüfung ob das ausgewählte Feld leer ist.
                        8. Win Condition prüfen. ♥
                        9. Patt Situation prüfen. ♥
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            Problem:    1. Eingegebener User Input von Player 1 in Zahl "1" ändern und von Player 2 in Zahl "2" (Gelöst) Im updateField mit if/else
                        2. Player Swap funktioniert nicht. (Gelöst) Prinzip funktioniert. if/else im Main Block ausführen zum Testen.
                        3. Nach dem Player Swap wird der Wert von Player 1 überschrieben obwohl ein anderes Feld ausgewählt wurde. (Gelöst) Falsch ausgeführt im Main Block
                        4. Spielfeld schon belegt und dann wechselt er den spieler direkt sollte nicht so sein.
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

// Code Review Edited with Gyula

public class TicTacToe_Edited {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int player = -1;
        int[][] gameField = createGameField();
        boolean win = false;
        boolean patt = false;

        printField(gameField);

        // 1. validMove Schleife durchlaufen || 2. Checken ob jmd gewinnt || 3. Checken, ob es patt ist || wiederholen
        while (!win && !patt) {

            player = playerSwap(player);

            // 1. Spieler auffordern || 2. Zug abfragen || 3. Zug checken || 4. Feld printen || 5. Spieler wechseln || wiederholen
            boolean validMove = false;
            while (!validMove) {
                System.out.println("Spieler " + player + " , mach dein Zug.");
                int userInput = controlUserInput("Das Spielfeld ist dem Numpad nach empfunden!\n     Welches Feld soll es sein 1-9?", 1, 9);
                int row = 2 - (userInput - 1) / 3; // row 2 - .. wegen der Numpad Reihenfolge
                int col = (userInput - 1) % 3;

                validMove = checkAndFillPosition(gameField, player, row, col);
            }

            win = checkWin(gameField, player);
            patt = checkPatt(gameField);
        }
        if (win) {
            System.out.println("Glückwunsch Player " + player + " hat Gewonnen");
        } else {
            System.out.println("Kein Spieler hat gewonnen!\nPatt Situation");
        }
    }

    public static boolean checkAndFillPosition(int[][] gameField, int player, int row, int col) {
        if (gameField[row][col] == 0) {
            gameField[row][col] = player;
            printField(gameField);
            return true;

        } else {
            System.out.println("[Feld schon belegt! Bitte ein neues Feld Auswählen!]\n[Das Spielfeld ist dem Numpad nach empfunden!]\n");
            return false;
        }
    }

    public static int[][] createGameField() {
        int[][] result = new int[3][3];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = 0;
            }
        }
        return result;
    }

    public static void printField(int[][] arr) {
        System.out.println("╔═════════════════╗");
        System.out.println("║   Tik Tak Toe   ║");
        System.out.println("╚═════════════════╝"); //17 leer
        for (int i = 0; i < arr.length; i++) {
            if (i == 0){
                System.out.println("╔═════╦═════╦═════╗");
            } else{
                System.out.println("╠═════╬═════╬═════╣");
            }
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("║  ");
                if (arr[i][j] == 1) {
                    System.out.print(Colors.COLORS[1] + "X" + Colors.RESET);
                } else if (arr[i][j] == 2) {
                    System.out.print(Colors.COLORS[4] + "O" + Colors.RESET);
                } else {
                    System.out.printf("%1d", 3 * (2 - i) + j + 1);
                }
                System.out.print("  ");
            }
            System.out.println("║"); //Rand Ende
        }
        System.out.println("╚═════╩═════╩═════╝");
    }

    public static int controlUserInput(String msg, int minValue, int maxValue) {
        int userInput = 0;
        boolean vaildNumber = false;

        while (!vaildNumber) {
            try {
                System.out.println(msg);
                System.out.print(">> ");
                userInput = sc.nextInt();
                if (userInput >= minValue && userInput <= maxValue) {
                    vaildNumber = true;
                } else {
                    System.out.println("Zwischen 1-9!");
                }

            } catch (InputMismatchException ime) {
                System.out.println("Fehler! Nur Zahlen");
            }
            sc.nextLine();
        }
        return userInput;
    }

    public static int playerSwap(int player) {
        if (player == 1) {
            return 2;
        } else {
            return 1;
        }
    }

    public static boolean checkWin(int[][] field, int player) {
        // Check Win Condition Horizontal
        if (field[0][0] == player && field[0][1] == player && field[0][2] == player) {
            return true;
        }
        if (field[1][0] == player && field[1][1] == player && field[1][2] == player) {
            return true;
        }
        if (field[2][0] == player && field[2][1] == player && field[2][2] == player) {
            return true;
        }

        // Check Win Condition Vertikal
        if (field[0][0] == player && field[1][0] == player && field[2][0] == player) {
            return true;
        }
        if (field[0][1] == player && field[1][1] == player && field[2][1] == player) {
            return true;
        }
        if (field[0][2] == player && field[1][2] == player && field[2][2] == player) {
            return true;
        }

        // Check Win Condition Diagonal
        if (field[0][0] == player && field[1][1] == player && field[2][2] == player) {
            return true;
        }
        if (field[0][2] == player && field[1][1] == player && field[2][0] == player) {
            return true;
        }

        return false;
    }

    public static boolean checkPatt(int[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
