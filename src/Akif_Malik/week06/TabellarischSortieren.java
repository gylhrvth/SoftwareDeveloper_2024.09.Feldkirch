package Akif_Malik.week06;

/*
            Todo:   1. Information von ccwiki abkoperien
                    2. in den Main einfügen
                    3. println für das zeile oben
                    4. printf mit formatierungen für die titeln dass es schön steht
                    5. printl für das zeile unten
                    6. for i schleife die so lange geht wie die firtname.length
                    7. printf mit formatierungen für die Informationen die angegeben sind
                    8. println für das zeile zwischen jede reihe
                    9. finish :=)


 */

import Sandro.Colors;

public class TabellarischSortieren {


    public static void main(String[] args) {
        String[] firstName = {"Alfonso", "Beatrix-Eleonor", "Cecil", "Daniel", "Elmar"};
        String[] lastName = {"Klein", "Kinderdorfer", "Al Elmenar", "Schmidt", "Simma"};
        int[] age = {40, 78, 5, 18, 81};
        String[] place = {"Wien", "Schwarzach", "Wiener Neudorf", "Sankt Pölten", "Sankt Pölten"};
        float[] distanceFromCapital = {0f, 654.4f, 12.457634366f, 120.0f, 119.9999f};


        System.out.println(Colors.COLORS[4] + "----------------------------------------------------------------------------------" + Colors.RESET);
        System.out.printf(Colors.COLORS[5] + "| %-20s | %-20s | %-5s | %-14s | %-10s|\n", "Name", "Surname", "Age", "Place", "Distance" + Colors.RESET);
        System.out.println(Colors.COLORS[4] + "----------------------------------------------------------------------------------");

        for (int i = 0; i < firstName.length; i++) {
            System.out.printf("| %-20s | %-20s | %-5d | %-14s | %-6.2f  |\n",
                    firstName[i], lastName[i], age[i], place[i], distanceFromCapital[i]);
            System.out.println("----------------------------------------------------------------------------------");
        }
    }
}