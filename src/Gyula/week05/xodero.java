package Gyula.week05;

public class xodero {
    public static void main(String[] args) {
        printXoderO(2);
    }

    public static void printXoderO(int i){
        if (i == 1){
            System.out.print("X");
        } else if (i == 2){
            System.out.print("O");
        } else {
            System.out.print(" ");
        }
    }
}
