package Aylin.Herbstferien;

public class Rhombus {
    public static void main(String[] args) {
        printRhombus("x", 7);
    }

    public static void printRhombus(String text, int count){
        if(count % 2 == 0) {
            count--;
        }

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if(j + count / 2 == i){
                    System.out.print(text);
                }else if(i + j == count / 2){
                    System.out.print(text);
                }else if(i + count / 2 == j){
                    System.out.print(text);
                }else if(i + j - (count / 2) == count - 1){
                    System.out.print(text);
                }else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
