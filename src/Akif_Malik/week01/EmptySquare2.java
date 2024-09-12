package Akif_Malik.week01;

public class EmptySquare2 {
    public static void main(String[] args) {
        emptySquare("A ", 3);
    }


    public static void emptySquare(String text, int maxRep){
        for (int zeile1 = 0; zeile1 < maxRep; zeile1++) {
            System.out.print(text);
        }
        System.out.println();


        for (int zeile2 = 0; zeile2 < maxRep - 2; zeile2++) {
            System.out.print(text);
            for (int mitte = 0; mitte < maxRep - 2; mitte++) {
                System.out.print(". ");
            }
            System.out.println(text);
        }
        for (int col = 0; col < maxRep; col++) {
            System.out.print(text);

        }
    }
    //public static void emptySquare(String text, int maxRep){
    //        for (int col = 0; col < maxRep; col++) {
    //            System.out.print(text);
    //        }
    //        System.out.println();
    //
    //        for (int zeile = 0; zeile < maxRep - 2; zeile++) {
    //            System.out.print(text);
    //            for (int spaces = 0; spaces < maxRep - 2; spaces++) {
    //                System.out.print(". ");
    //            }
    //            System.out.println(text);
    //        }
    //
    //        for (int col = 0; col < maxRep; col++) {
    //            System.out.print(text);
    //        }
    //        System.out.println();
    //    }

}
