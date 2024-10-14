package Furkan.week06;

public class DatenTabellarisch {
    public static void main(String[] args) {
        String[] firstName = {"Alfonso", "Beatrix-Eleonor", "Cecil", "Daniel", "Elmar"};
        String[] lastName = {"Klein", "Kinderdorfer", "Al Elmenar", "Schmidt", "Simma"};
        int[] age = {40, 78, 5, 18, 81};
        String[] place = {"Wien", "Schwarzach", "Wiener Neudorf", "Sankt Pölten", "Sankt Pölten"};
        float[] distanceFromCapital = {0f, 654.4f, 12.457634366f, 120.0f, 119.9999f};

        printAsTable(firstName, lastName, age, place, distanceFromCapital);
    }


    public static void printAsTable(String[] firstName, String[] lastName, int[] age, String[] place, float[] distance) {
        System.out.println("Hello Furkan");

        System.out.printf("|%20s | %20s | %20d | %20s | %20.2f | \n",
                firstName[0],
                lastName[0],
                age[0],
                place[0],
                distance[0]);



            for (int i = 0; i < firstName.length; i++) {
                System.out.printf("");
            }

    }


}
