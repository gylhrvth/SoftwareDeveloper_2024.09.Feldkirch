package Sandro.Week5;

public class PrintTabelle {
    public static void main(String[] args) {

        String[] firstName = {"Alfonso", "Beatrix-Eleonor", "Cecil", "Daniel", "Elmar"};
        String[] lastName = {"Klein", "Kinderdorfer", "Al Elmenar", "Schmidt", "Simma"};
        int[] age = {40, 78, 5, 18, 81};
        String[] place = {"Wien", "Schwarzach", "Wiener Neudorf", "Sankt Pölten", "Sankt Pölten"};
        float[] distanceFromCapital = {0f, 654.4f, 12.457634366f, 120.0f, 119.9999f};


        String firstNameHeader = "Firstname";
        String lastNameHeader = "LastName";
        String ageHeader = "Age";
        String placeHeader = "Place";
        String distanceHeader = "Distance from Capital";

        printTabelle(firstName, lastName, age, place, distanceFromCapital, firstNameHeader, lastNameHeader, ageHeader, placeHeader, distanceHeader);

    }

    public static void printTabelle(String[] first, String[] last, int[] age, String[] place, float[] distance, String header1, String header2, String header3, String header4, String header5) {
        int maxLength1 = tabspaceStrings(header1, first);
        int maxLength2 = tabspaceStrings(header2, last);
        int maxLength3 = tabspaceINT(header3, age);
        int maxLength4 = tabspaceStrings(header4, place);
        int maxLength5 = tabspaceFloat(header5, distance);


        System.out.printf("[" + " %-" + maxLength1 + "s " + "]", header1);
        System.out.printf("[" + " %-" + maxLength2 + "s " + "]", header2);
        System.out.printf("[" + " %-" + maxLength3 + "s " + "]", header3);
        System.out.printf("[" + " %-" + maxLength4 + "s " + "]", header4);
        System.out.printf("[" + " %-" + maxLength5 + "s " + "]", header5);
        System.out.println();
        System.out.printf("[" + " %-" + maxLength1 + "s " + "]", "#".repeat(maxLength1));
        System.out.printf("[" + " %-" + maxLength2 + "s " + "]", "#".repeat(maxLength2));
        System.out.printf("[" + " %-" + maxLength3 + "s " + "]", "#".repeat(maxLength3));
        System.out.printf("[" + " %-" + maxLength4 + "s " + "]", "#".repeat(maxLength4));
        System.out.printf("[" + " %-" + maxLength5 + "s " + "]", "#".repeat(maxLength5));
        System.out.println();

        for (int i = 0; i < first.length; i++) {
            System.out.printf("[" + " %-" + maxLength1 + "s " + "]", first[i]);
            System.out.printf("[" + " %-" + maxLength2 + "s " + "]", last[i]);
            System.out.printf("[" + " %-" + maxLength3 + "s " + "]", age[i]);
            System.out.printf("[" + " %-" + maxLength4 + "s " + "]", place[i]);
            System.out.printf("[" + " %-" + maxLength5 + "s " + "]", distance[i]);
            System.out.println();
        }
    }

    public static int tabspaceStrings(String header, String[] arr) {
        int maxLength = header.length();

        for (String name : arr) {
            if (maxLength < name.length()) {
                maxLength = name.length();
            }
        }
        return maxLength;
    }

    public static int tabspaceFloat(String header, float[] arr) {
        int maxLen = header.length();
        for (float nameFromArr : arr) {
            String text = String.format("%.2f", nameFromArr);
            if (text.length() > maxLen) {
                maxLen = text.length();
            }
        }
        return maxLen;
    }

    public static int tabspaceINT(String header, int[] arr) {
        int maxLen = header.length();
        for (int nameFromArr : arr) {
            String text = String.format("%d", nameFromArr);
            if (text.length() > maxLen) {
                maxLen = text.length();
            }
        }
        return maxLen;
    }


}
