package Furkan.week05;

import java.util.InputMismatchException;

public class Sleeeeeep {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException ie){}
        }
    }
}
