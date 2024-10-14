package Sandro.Week5;

public class StringExample {
    public static void main(String[] args) {

        String word1 = "Sandro";
        String word2 = "Aylin";

        System.out.println(word2.compareTo(word1));
        int var = 77;

       System.out.printf("char = %c  -- die zahl : %d",(char)var, var);

        char [] test = word1.toCharArray();
        word1.toCharArray();
/*
        for (int i = 0; i < 255; i++) {
            System.out.println("Was ist der Char? ("+ i +") ---> "+(char)i);
        }
*/


        int value = Integer.MAX_VALUE;




    }
}
