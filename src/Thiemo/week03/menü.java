package Thiemo.week03;


import Thiemo.week02.Ratespiel2;

import java.util.Scanner;

public class menü {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to my Drawings \n What do you want to draw?\n 1 = XmassTree \n 2 = Quader \n 3= Rhombus");

        int menue = Ratespiel2.range("Choose between: ", 0, 3);



        if (menue == 1) {
           Thiemo.week01.christmastree.christmastree();
        }
        else if (menue == 2) {
         Thiemo.week01.emptysquare.EmptySquareX();
        }
        else if (menue == 3){
            Thiemo.week01.rhombus.printrhombus();
        }
        System.out.println("Ok");











//        public static void menueXmasstree
//             int size =
//
//        public static void menueQuader
//
//
//        public static void menuRhombus

    }

}





