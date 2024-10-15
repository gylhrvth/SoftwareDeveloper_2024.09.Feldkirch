package Aylin.week06;


public class DatenTabellarischDarstellen {
    public static void main(String[] args) {
        String[] firstName = {"Alfonso", "Beatrix-Eleonor", "Cecil", "Daniel", "Elmar"};
        String[] lastName = {"Klein", "Kinderdorfer", "Al Elmenar", "Schmidt", "Simma"};
        int[] age = {40, 78, 5, 18, 81};
        String[] place = {"Wien", "Schwarzach", "Wiener Neudorf", "Sankt Pölten", "Sankt Pölten"};
        float[] distanceFromCapital = {0f, 654.4f, 12.457634366f, 120.0f, 119.9999f};

        printTable(firstName, lastName, age, place, distanceFromCapital);
        System.out.println();
        layout(table());
    }

    public static void printTable(String[] firstName, String[] lastName, int[] age, String[] place, float[] distance){
        String firstNameHeader = "Firstname";
        String lastNameHeader = "Surname";
        String ageHeader = "Age";
        String placeHeader = "Place";
        String distanceHeader = "Distance";

        int totalLength = getMaxLength(firstNameHeader, firstName)+ 3 + getMaxLength(lastNameHeader, lastName)+ 3 + getMaxLengthInt(ageHeader, age)+ 3 + getMaxLength(placeHeader, place)+ 3 + getMaxLengthFloat(distanceHeader, distance )+ 3;

        System.out.println("_".repeat(totalLength));
        System.out.printf("|%-"+getMaxLength(firstNameHeader, firstName)+"s | %-"+getMaxLength(lastNameHeader, lastName)+"s | %"+getMaxLengthInt(ageHeader, age)+"s | %-"+getMaxLength(placeHeader, place)+"s | %"+getMaxLengthFloat(distanceHeader, distance)+"s |\n",
                firstNameHeader, lastNameHeader, ageHeader, placeHeader, distanceHeader);
        System.out.println("_".repeat(totalLength));

        String[] columnNames = new String[]{"Firstname", "Lastname", "Age", "Place", "Distance"};
        for (int i = 0; i < columnNames.length; i++) {
            System.out.printf("");
        }

        for (int i = 0; i < firstName.length; i++) {
            System.out.printf("|%-"+getMaxLength(firstNameHeader, firstName)+"s | %-"+getMaxLength(lastNameHeader, lastName)+"s | %"+getMaxLengthInt(ageHeader, age)+"d | %-"+getMaxLength(placeHeader, place)+"s | %"+getMaxLengthFloat(distanceHeader, distance)+".2f |\n",
                    firstName[i], lastName[i], age[i], place[i], distance[i]);
        }
        System.out.println("_".repeat(totalLength));
    }

    public static int getMaxLength(String header, String[] array) {
        int maxLength = header.length();
        for (String str : array) {
            if (str.length() > maxLength) {
                maxLength = str.length();
            }
        }
        return maxLength;
    }

    public static int getMaxLengthInt(String header, int[] array) {
        int maxLength = header.length();
        for (int value : array) {
            maxLength = Math.max(maxLength, String.valueOf(value).length());
        }
        return maxLength;
    }

    public static int getMaxLengthFloat(String header, float[] array) {
        int maxLength = header.length();
        for (float value : array) {
            maxLength = Math.max(maxLength, String.valueOf(value).length());
        }
        return maxLength;
    }

    public static String[][] table(){
        String[][] table = new String[5][];
        table[0] = new String[] {"Alfonso", "Beatrix-Eleonor", "Cecil", "Daniel", "Elmar"};
        table[1] = new String[] {"Klein", "Kinderdorfer", "Al Elmenar", "Schmidt", "Simma"};
        table[2] = new String[] {"40", "78", "5", "18", "81"};
        table[3] = new String[] {"Wien", "Schwarzach", "Wiener Neudorf", "Sankt Pölten", "Sankt Pölten"};
        table[4] = new String[] {"0f", "654.4f", "12.457634366f", "120.0f", "119.9999f"};

        return table;
    }

    public static void layout(String[][] arr) {
        System.out.println("_______________________________________________________________________________________________");
        System.out.println("| Name                | Surname              | Age   | Place                | Distance        |");
        System.out.println("_______________________________________________________________________________________________");
        for (int i = 0; i <arr.length; i++) {
            System.out.printf("|%-20s | %-20s | %-5s | %-20s | %-15s |\n", arr[0][i], arr[1][i], arr[2][i], arr[3][i], arr[4][i]);
        }
        System.out.println("_______________________________________________________________________________________________");
    }
}
