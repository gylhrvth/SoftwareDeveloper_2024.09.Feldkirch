package Erik.week02;

import java.util.Scanner;

public class ObjectWithPrintX {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Gib ein Symbol und die Größe ein: ");
        String text = sc.next();
        int size = sc.nextInt();

        Erik.week01.PrintX.printX(text, size);

        

    }
}
