package Akif_Malik.week06;

import java.util.InputMismatchException;

public class EverySingleCharactersAvailable {
    public static void main(String[] args) {
        for (int i = 0; i < Character.MAX_VALUE; i++) {
            System.out.println("Character " + i + " <---> " + (char)i);

            if (i % 50 == 0) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ie) {
                }
            }
        }
    }
}
