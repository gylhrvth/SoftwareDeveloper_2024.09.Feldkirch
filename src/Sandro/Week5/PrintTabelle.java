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

        printTabelle(firstName,lastName,age,place,distanceFromCapital,firstNameHeader,lastNameHeader,ageHeader,placeHeader,distanceHeader);


    }

    public static void printTabelle(String [] first, String [] last, int [] age, String [] place, float[] distance, String header1, String header2, String header3, String header4, String header5){
        int maxLength1 = stringSpaces(header1,first);
        int maxLength2 = stringSpaces(header2,last);
        //age
        int maxLength4 = stringSpaces(header4, place);
        //distance


        System.out.printf("["  + " %-" + maxLength1 + "s "  + "]", header1);
        System.out.printf("["  + " %-" + maxLength2 + "s "  + "]", header2);
        //age
        System.out.printf("["  + " %-" + maxLength4 + "s "  + "]", header4);
        //distance
        System.out.println();
        System.out.println();

        for (int i = 0; i < first.length; i++) {
            System.out.printf("["  + " %-" + maxLength1 + "s "  + "]", first[i]);
            System.out.printf("["  + " %-" + maxLength2 + "s "  + "]", last[i]);
            //age
            System.out.printf("["  + " %-" + maxLength4 + "s "  + "]", place[i]);
            //distance
            System.out.println();
        }





    }


    public static int stringSpaces(String header, String[] arr) {
        int maxLength = header.length();

        for (String name : arr) {
            if(maxLength < name.length()){
                maxLength = name.length();
            }
        }


        return maxLength;
    }


}
