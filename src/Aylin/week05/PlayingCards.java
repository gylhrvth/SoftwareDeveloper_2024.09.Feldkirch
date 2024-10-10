package Aylin.week05;

import Sandro.Colors;

import java.util.Arrays;
import java.util.Random;

public class PlayingCards {

    public static Random random = new Random();

    public static void main(String[] args) {
        gameLogic(50);
    }

    public static void gameLogic(int count){;
        int[] deck = new int[52];
        for (int i = 0; i < count; i++) {
            String mySuit = getRandomSuit();
            if(mySuit.equals("Hearts")  || mySuit.equals("Diamonds")) {
                System.out.println(Colors.COLORS[1] + cards() + " of " + mySuit + Colors.RESET);
            }else{
                System.out.println(Colors.COLORS[7] + cards() + " of " + mySuit + Colors.RESET);
            }
        }
    }

    public static String cards(){
        int numbers = random.nextInt(1, 14);
        if (numbers == 1) {
            return  "Ace";
        } else if (numbers == 11) {
            return "Jack";
        } else if (numbers == 12) {
            return "Queens";
        } else if (numbers == 13) {
            return "King";
        }
        return Integer.toString(numbers);
    }

    public static String[] suits(){
        String[] stringArray = null;
        stringArray = new String[4];

        stringArray[0] = "Hearts";
        stringArray[1] = "Diamonds";
        stringArray[2] = "Clubs";
        stringArray[3] = "Spades";

        return stringArray;
    }

    public static String getRandomSuit(){
        String[] suitsArray = suits();
        int randomIndex = random.nextInt(suitsArray.length);
        return suitsArray[randomIndex];
    }
}
