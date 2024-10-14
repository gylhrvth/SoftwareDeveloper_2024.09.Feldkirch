package Gyula.week06;

public class PrintTableFormatedData {
    public static void main(String[] args) {
        String[] firstName = {"Alfonso", "Beatrix-Eleonor", "Cecil", "Daniel", "Elmar"};
        String[] lastName = {"Klein", "Kinderdorfer", "Al Elmenar", "Schmidt", "Simma"};
        int[] age = {40, 78, 5, 18, 81};
        String[] place = {"Wien", "Schwarzach", "Wiener Neudorf", "Sankt Pölten", "Sankt Pölten"};
        float[] distanceFromCapital = {0f, 654.4f, 12.457634366f, 120.0f, 119.9999f};


        printAsTable(firstName, lastName, age, place, distanceFromCapital);
    }

    public static void printAsTable(
            String[] firstName,
            String[] lastName,
            int[] age,
            String[] place,
            float[] distance){

        String[] columnNames = new String[]{"Firstname ist ein lange Titel", "Lastname", "Age", "Place", "Distance"};
        int firstNameWidth = getMaxColumnWith(columnNames[0], firstName);
        int lastNameWidth = getMaxColumnWith(columnNames[1], lastName);
        int ageWidth = getMaxColumnWith(columnNames[2], age);
        int placeWidth = getMaxColumnWith(columnNames[3], place);
        int distanceWidth = getMaxColumnWith(columnNames[4], distance);

        String formatStringHeader = String.format(
                "| %%-%ds | %%-%ds | %%%ds | %%-%ds | %%%ds |\n",
                firstNameWidth,
                lastNameWidth,
                ageWidth,
                placeWidth,
                distanceWidth);
        System.out.printf(formatStringHeader,
                columnNames[0],
                columnNames[1],
                columnNames[2],
                columnNames[3],
                columnNames[4]);
        System.out.printf(formatStringHeader,
                "-".repeat(firstNameWidth),
                "-".repeat(lastNameWidth),
                "-".repeat(ageWidth),
                "-".repeat(placeWidth),
                "-".repeat(distanceWidth));

        //String formatString = "| %-" + firstNameWidth + "s | %-20s | %20d | %-20s | %20.2f |\n";
        String formatString = String.format(
                "| %%-%ds | %%-%ds | %%%dd | %%-%ds | %%%d.2f |\n",
                firstNameWidth,
                lastNameWidth,
                ageWidth,
                placeWidth,
                distanceWidth);

        for (int i = 0; i < firstName.length; i++) {
            System.out.printf(formatString,
                    firstName[i],
                    lastName[i],
                    age[i],
                    place[i],
                    distance[i]);
        }
    }

    public static int getMaxColumnWith(String titel, String[] text){
        int result = titel.length();
        for (int i = 0; i < text.length; i++) {
            if (result < text[i].length()){
                result = text[i].length();
            }
        }
        return  result;
    }

    public static int getMaxColumnWith(String titel, int[] values){
        int result = titel.length();
        for (int i = 0; i < values.length; i++) {
            String text = Integer.toString(values[i]);
            if (result < text.length()){
                result = text.length();
            }
        }
        return  result;
    }

    public static int getMaxColumnWith(String titel, float[] values){
        int result = titel.length();
        for (int i = 0; i < values.length; i++) {
            String text = String.format("%.2f", values[i]);
            if (result < text.length()){
                result = text.length();
            }
        }
        return  result;
    }

}
