package Thiemo.week06;

import Sandro.Colors;

public class DatanTabellarisch2 {


    public static void main(String[] args) {

        String[] headline = {"Firstname", "LastName", "Age", "Place", "DistanceFromCapital"};
        String[] firstName = {"Alfonso", "Beatrix-Eleonor", "Cecil", "Daniel", "Elmar"};
        String[] lastName = {"Klein", "Kinderdorfer", "Al Elmenar", "Schmidt", "Simma"};
        int[] age = {40, 78, 5, 18, 81};
        String[] place = {"Wien", "Schwarzach in Vorarlberg nördlich von Dornbirn", "Wiener Neudorf", "Sankt Pölten", "Sankt Pölten"};
        float[] distanceFromCapital = {0f, 654.4f, 12.457634366f, 120.0f, 119.9999f};


        printFormat(headline, firstName, lastName, age, place, distanceFromCapital);


    }

    public static void printFormat(String[] headline, String[] firstName, String[] lastName, int[] age, String[] place, float[] distanceFromCapital) {


        int agesize = formatIntSize(age,headline[2]);
        int firstNameSize = formatStringSize(firstName,headline[0]);
        int lastNameSize = formatStringSize(lastName,headline[1]);
        int placeSize = formatStringSize(place,headline[3]);
        int distanceSize = formatFloatSize(distanceFromCapital,headline[4]);


        System.out.println();

        System.out.println("╔═" + "═".repeat(firstNameSize) + "═╦═" + "═".repeat(lastNameSize) + "═╦═" + "═".repeat(agesize) + "═╦═" + "═".repeat(placeSize) + "═╦═" + "═".repeat(distanceSize) + "═╗");
        System.out.printf("║ "+Colors.COLORS[1]+"%-" + firstNameSize + "s"+Colors.RESET+" ║ "+Colors.COLORS[1]+"%-" + lastNameSize + "s"+Colors.RESET+" ║ "+Colors.COLORS[1]+"%" + agesize + "s"+Colors.RESET+" ║ "+Colors.COLORS[1]+"%-" + placeSize + "s"+Colors.RESET+" ║  "+Colors.COLORS[1]+"%" + distanceSize + "s"+Colors.RESET+"║",headline[0],headline[1], headline[2], headline[3], headline[4]);


        System.out.println();
        System.out.println("╠═" + "═".repeat(firstNameSize) + "═╬═" + "═".repeat(lastNameSize) + "═╬═" + "═".repeat(agesize) + "═╬═" + "═".repeat(placeSize) + "═╬═" + "═".repeat(distanceSize) + "═╣");
        for (int i = 0; i < firstName.length; i++) {
            System.out.printf("║ %-" + firstNameSize + "s ║ %-" + lastNameSize + "s ║ %" + agesize + "d ║ %-" + placeSize + "s ║ %" + distanceSize + ".2f ║", firstName[i], lastName[i], age[i], place[i], distanceFromCapital[i]);
            System.out.println();
            if (i < firstName.length - 1) {
                System.out.println("╠═" + "═".repeat(firstNameSize) + "═╬═" + "═".repeat(lastNameSize) + "═╬═" + "═".repeat(agesize) + "═╬═" + "═".repeat(placeSize) + "═╬═" + "═".repeat(distanceSize) + "═╣");
            }
            if (i == firstName.length - 1) {
                System.out.println("╚═" + "═".repeat(firstNameSize) + "═╩═" + "═".repeat(lastNameSize) + "═╩═" + "═".repeat(agesize) + "═╩═" + "═".repeat(placeSize) + "═╩═" + "═".repeat(distanceSize) + "═╝");
            }
        }
    }

    public static int formatIntSize(int[] age, String headline) {
        int result = headline.length();
        for (int i = 0; i < age.length; i++) {
            String text = String.valueOf(age[i]);
            if (result < text.length()) {
                result = text.length();
            }
        }
        return result;
    }

    public static int formatStringSize(String[] count,String headline) {
        int result = headline.length();
        for (int i = 0; i < count.length; i++) {
            if (result < count[i].length()) {
                result = count[i].length();
            }
        }
        return result;
    }

    public static int formatFloatSize(float[] distanceFromCapital,String headline) {
        int result = headline.length();
        for (int i = 0; i < distanceFromCapital.length; i++) {
            String text = String.format("%.2f", distanceFromCapital[i]);
            if (result < text.length()) {
                result = text.length();
            }
        }
        return result;
    }
}




