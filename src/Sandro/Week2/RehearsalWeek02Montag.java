package Sandro.Week2;

public class RehearsalWeek02Montag {
    public static void main(String[] args) {
/*
        //int, float, String Var init
        //printf with one, two, all
        // %d10, %6.1f, %20s

        int number = 150;
        float komma = 3.1897f;
        String text = "ich bin ein text";
        System.out.println(text);

        System.out.printf("%10d nach der var ",number);
        System.out.println();
        System.out.printf("%10d .... %-6.1f  \n",number, komma );

        System.out.printf("%10d .... %-6.3f",number, komma );
        System.out.println();
        System.out.printf("%10s ... %6.2f ---- %55s", text,komma,text);
        System.out.println();

*/
        //int a und b init
        //Methoden für print weg, print ergebnis, addieren und doEverything

        int a = 12;
        int b = 26;


        System.out.println(addieren(a, b));

         doEverything(a, b);
    }

    public static void doEverything(int a, int b) {
        int sum = 0;
        printRechenWeg(a, b);
        sum = addieren(a, b);
        printSum(sum);

    }

    public static void printRechenWeg(int a, int b) {
        System.out.println("Rechenweg : " + a + " + " + b);

    }

    public static int addieren(int a, int b) {
        int sum = 0;
        sum = a + b;

        return sum;
    }

    public static void printSum(int sum) {
        System.out.println("Summe ist : " + sum);
    }

}
