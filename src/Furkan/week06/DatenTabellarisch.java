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

        String[] columnNames = new String[]{"Firstname", "Lastname", "Age", "Place" , "Distance"};

      //  System.out.printf("|%1$-20s | %2$-20s | %3$-20s | %4$-20s | %5$-20s | %n", columnNames[0], columnNames[1], columnNames[2], columnNames[3],columnNames[4]);
        System.out.printf("|%-20s | %-20s | %20s | %-20s | %20s | %n", columnNames[0], columnNames[1], columnNames[2], columnNames[3],columnNames[4]);
        System.out.println("----------------------|----------------------|----------------------|----------------------|----------------------|");


        for (int i = 0; i < firstName.length; i++) {
         //   System.out.printf("|%1$-20s | %2$-20s | %3$20d | %4$-20s | %5$20.2f | %n" , firstName[i],lastName[i],age[i],place[i],distance[i]);
            System.out.printf("|%-20s | %-20s | %20d | %-20s | %20.2f | %n" , firstName[i],lastName[i],age[i],place[i],distance[i]);
            
        }
    }


}

 // System.out.printf("|%20s | %20s | %20d | %20s | %20.2f | \n");
