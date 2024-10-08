package Erik.week04;

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

                        Problem:    1. Eingegebener User Input von Player 1 in Zahl "1" ändern und von Player 2 in Zahl "2" (Gelöst) Im updateField mit if/else
                                    2. Player Swap funktioniert nicht. (Gelöst) Prinzip funktioniert. if/else im Main Block ausführen zum Testen.
                                    3. Nach dem Player Swap wird der Wert von Player 1 überschrieben obwohl ein anderes Feld ausgewählt wurde. (Gelöst) Falsch ausgeführt im Main Block
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int player = 1;
        int[][] gameField = createGameField();

        playTicTacToe(gameField);

//        printField(gameField);
//        System.out.println("Spieler " + player + " , mach dein Zug.");
//        for (int i = 0; i < 8; i++) {
//
//           int userInput = controlUserInput("[Das Spielfeld ist dem Numpad nach empfunden!]\n     [Welches Feld soll es sein 1-9?]", 1, 9);
//            updateField(gameField, userInput, player);
//            printField(gameField);
//            if (player == 1) {
//                player = 2;
//            } else if (player == 2) {
//                player = 1;
//            }
//            System.out.println("Spieler " + player + " , mach dein Zug.");
//        }

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

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%3d", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static int controlUserInput(String msg, int minValue, int maxValue) {
        int userInput = 0;
        boolean vaildNumber = false;

        while (!vaildNumber) {
            try {
                System.out.println(msg);
                userInput = sc.nextInt();
                if (userInput >= minValue && userInput <= maxValue) {
                    vaildNumber = true;
                } else {
                    System.out.println("Between 1-9!");
                }

            } catch (InputMismatchException ime) {
                System.out.println("Error Only Numbers");
            }
            sc.nextLine();
        }
        return userInput;
    }

    public static void updateField(int[][] gameField, int userInput, int player) {
// User Input wird abgeglichen und hier muss ich, den eingegeben Input von player 1 und 2 auf "1" und "2" schreiben?
        int row = 0; //        row = (userInput-1) /3;
        int col = 0; //        col = (userInput-1) %3;
        // Game Field ist dem Numpad nach empfunden
        if (userInput == 7) {
            row = 0;
            col = 0;
        } else if (userInput == 8) {
            row = 0;
            col = 1;
        } else if (userInput == 9) {
            row = 0;
            col = 2;
        } else if (userInput == 4) {
            row = 1;
            col = 0;
        } else if (userInput == 5) {
            row = 1;
            col = 1;
        } else if (userInput == 6) {
            row = 1;
            col = 2;
        } else if (userInput == 1) {
            row = 2;
            col = 0;
        } else if (userInput == 2) {
            row = 2;
            col = 1;
        } else if (userInput == 3) {
            row = 2;
            col = 2;
        }

        if (gameField[row][col] == 0){
            gameField[row][col] = player;
        } else {
            System.out.println("Feld schon belegt!");
        }

//        if (player == 1) {
//            gameField[row][col] = userInput;
//            userInput = 1;
//        } else if (player == 2) {
//            gameField[row][col] = userInput;
//            userInput = 2;
//        }
//        gameField[row][col] = userInput;

    }

    public static void playTicTacToe(int[][] gameField){
        int player = 1;
        boolean winGame = false;


        while(!winGame){
            printField(gameField);
            System.out.println("Spieler " + player + " , mach dein Zug.");
            for (int i = 0; i < 8; i++) {

                int userInput = controlUserInput("[Das Spielfeld ist dem Numpad nach empfunden!]\n     [Welches Feld soll es sein 1-9?]", 1, 9);
                updateField(gameField, userInput, player);
                printField(gameField);
                if (player == 1) {
                    player = 2;
                } else if (player == 2) {
                    player = 1;
                }
                System.out.println("Spieler " + player + " , mach dein Zug.");
            }
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
        if (field[1][0] == player && field[1][1] == player && field[2][1] == player) {
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

    public static boolean checkPatt(int[][] field, int player) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[j].length; j++) {
                if (field[i][j] == 0) {
                    System.out.println("Spiel geht weiter");
                } else {
                    System.out.println("Spiel vorbei keine freien Felder mehr!");
                }
            }
        }



        return false;
    }


























    public static void gameLogicOld(int[][] arr) {
        int count = 0;
        int player1 = 1;
        int player2 = 2;
        int validMove = 0; // Filler

        boolean win = false;
        boolean validInteraction = false;

        while (!win && count < 9) {

//            for (int i = 0; i < arr.length; i++) {
//                for (int j = 0; j < arr[i].length; j++) { //Geht das Spielfeld durch und prüft, ob jemand gewonnen hat
//                    if (player1 == player1Win) {
//                        System.out.println("Spieler 1 Gewinnt!\nSpieler 2 hat Verloren.");
//                    } else if (player2 == player2Win) {
//                        System.out.println("Spieler 2 Gewinnt!\nSpieler 1 hat Verloren.");
//                    }
//                    win = true;
//                }
//            }
            // wenn Spieler 1 3x"1" in einer Reihe, Spalte, Diagonale hat, gewinnt Spieler 1.
            // wenn Spieler 2 3x"2" in einer Reihe, Spalte, Diagonale hat, gewinnt Spieler 2.
            // wenn keiner der Spieler diese Voraussetzung erfüllt und die maximale Spielzug Anzahl von "9Stk." erreicht wurde, dann ist es ein Unentschieden.

            while (!validInteraction)
                validMove = controlUserInput("", 1, 9);
//                if (player1)
            validInteraction = true;


            if (player1 == 1) {
                player2 = 2;
            } else {
                player1 = 1;
            }
            // Spieler 1 abfrage nach Numpad stellen 1-9 (Scanner)
            // Spieler 1 abfrage, ob das feld noch frei ist (if/else)
            // Spielfeld wird neu geprintet mit dem neuen Wert (Spielfeld print neuer Aufruf)
            // Spieler swap


        }
    }
}


//        playerSwap(player);

//public static int playerSwap(int player) {
//
//    if (player == 1) {
//        player = 2;
//    } else if (player == 2) {
//        player = 1;
//    }
//    return player;
//}

//int[][] testfeld = {
//        {1, 1, 1},
//        {0, 0, 0},
//        {0, 0, 0}
//};

//public static void winCondition(int[][] arr) {
//    int[][] testfeld = {
//            {1, 1, 1},
//            {0, 0, 0},
//            {0, 0, 0}
//    };
////        printField(testfeld);
//
//    int player1 = 1;
//    int player1Win = 3;
//    int player2 = 2;
//    int player2Win = 6;
//    boolean win = false;
//
//    while (!win)
//        for (int i = 0; i < testfeld.length; i++) {
//            for (int j = 0; j < testfeld[i].length; j++) { //Geht das Spielfeld durch und prüft, ob jemand gewonnen hat
//                if (testfeld[0][0] == testfeld[i][j]) {
//                    System.out.println("Spieler 1 Gewinnt!\nSpieler 2 hat Verloren.");
//                } else if (player2 == player2Win) {
//                    System.out.println("Spieler 2 Gewinnt!\nSpieler 1 hat Verloren.");
//                }
//
//            }
//            win = true;
//        }
//
//}
