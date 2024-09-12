package Sandro.Week1;

public class Rehearsal {
    public static void main(String[] args) {

        printRectangle("X", 5, 10, false);
        printGrid("X",5,true);
    }

    public static void printRectangle(String symbol, int lenght, int width, boolean direction) {

        if (direction == true) {
            for (int i = 0; i < lenght; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.print(symbol + " ");
                }
                System.out.println();
            }

        } else {

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < lenght; j++) {
                    System.out.print(symbol + " ");
                }
                System.out.println();
            }
        }

    }

    public static void printGrid(String symbol, int size, boolean showgrid){

        if (showgrid == true){
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                        System.out.print("i"+i + " " + "j"+j);
                    System.out.print(" | ");
                }
                System.out.println();
                System.out.print("------  ------  ------  ------  ------ ");
                System.out.println();
            }


        }else{

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (i + j == size-1){
                        System.out.print(symbol);
                    }else {
                        System.out.print(".");
                    }
                }
                System.out.println();
            }
        }


    }

}
