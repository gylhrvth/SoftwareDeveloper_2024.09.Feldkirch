package Aylin.week06;


public class DatenTabellarischDarstellen {
    public static void main(String[] args) {
        String[] firstName = {"Alfonso", "Beatrix-Eleonor", "Cecil", "Daniel", "Elmar"};
        String[] lastName = {"Klein", "Kinderdorfer", "Al Elmenar", "Schmidt", "Simma"};
        int[] age = {40, 78, 5, 18, 81};
        String[] place = {"Wien", "Schwarzach", "Wiener Neudorf", "Sankt Pölten", "Sankt Pölten"};
        float[] distanceFromCapital = {0f, 654.4f, 12.457634366f, 120.0f, 119.9999f};

        printAsTable(firstName, lastName, age, place, distanceFromCapital);


        System.out.println();
        layout(table());
    }

    public static void printAsTable(String[] firstName, String[] lastName, int[] age, String[] place, float[] distance){
        System.out.println("___________________________________________________________________");
        System.out.printf("|%-"+getMaxLength(firstName)+"s | %-"+getMaxLength(lastName)+"s | %"+getMaxLengthInt(age)+"s | %-"+getMaxLength(place)+"s | %"+getMaxLengthFloat(distance)+"s |\n", "Name", "Surname", "Age", "Place", "Distance");
        System.out.println("___________________________________________________________________");

        String[] columnNames = new String[]{"Firstname", "Lastname", "Age", "Place", "Distance"};
        for (int i = 0; i < columnNames.length; i++) {
            System.out.printf("");
        }

        for (int i = 0; i < firstName.length; i++) {
            System.out.printf("|%-"+getMaxLength(firstName)+"s | %-"+getMaxLength(lastName)+"s | %"+getMaxLengthInt(age)+"d | %-"+getMaxLength(place)+"s | %"+getMaxLengthFloat(distance)+".2f |\n", firstName[i], lastName[i], age[i], place[i], distance[i]);
        }
        System.out.println("___________________________________________________________________");
    }

    public static int getMaxLength(String[] array) {
        int maxLength = 0;
        for (String str : array) {
            if (str.length() > maxLength) {
                maxLength = str.length();
            }
        }
        return maxLength;
    }

    public static int getMaxLengthInt(int[] array) {
        int maxLength = 0;
        for (int value : array) {
            maxLength = Math.max(maxLength, String.valueOf(value).length());
        }
        return maxLength;
    }

    public static int getMaxLengthFloat(float[] array) {
        int maxLength = 0;
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
