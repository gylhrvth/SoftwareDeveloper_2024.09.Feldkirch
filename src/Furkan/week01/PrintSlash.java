package Furkan.week01;

public class PrintSlash {
    public static void main(String[] args) {
        printBackSlash("x", 3);
        printForwardSlash("y", 4);
    }



   public static void printBackSlash(String text, int count){
        for (int row= 0; row< count; row++){
            for (int col = 0; col < count; col++){
                if (col== row){
                    System.out.print(text);
                } else {
                    System.out.println(".");
                }
            }
            System.out.println();
        }



    }




    public static void printForwardSlash(String text, int count){

        for (int row= 0; row <count; row++ ){
            for (int col = 0; col< count  ;col++){
                System.out.print(". ");
            }
            System.out.println(text);

        }
    }
}
