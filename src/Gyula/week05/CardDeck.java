package Gyula.week05;

import java.util.Random;

public class CardDeck {
    public static Random random = new Random();
    public static void main(String[] args) {
        int[] deck = generateDeck();

        for (int i = 0; i < 50 * deck.length; i++) {
            swap(deck, random.nextInt(deck.length), random.nextInt(deck.length));
        }

        for (int i = 0; i < deck.length; i++) {
            System.out.println(getCardName(deck[i]));
        }
    }

    public static void swap(int[] arr, int pos1, int pos2){
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    public static int[] generateDeck(){
        int[] deck = new int[52];
        for (int i = 0; i < deck.length; i++) {
            deck[i] = i;
        }
        return deck;
    }

    public static String getCardName(int cardValue){
        if (cardValue < 0 || cardValue > 51){
            System.out.println("There is no card");
        }
        String[] suitsName = new String[]{"Club", "Diamond", "Heart", "Spades"};
        String[] numberName = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        int suits = cardValue / 13;
        int number = cardValue % 13;

        return numberName[number] + " of " + suitsName[suits];
    }
}
