package Akif_Malik.week07.tests;

import Akif_Malik.week07.Loggings;

public class TestApplication {
    public static void main(String[] args) {
        for (int i = 0; i < 20000; i++) {
            Loggings.log(3, "You've got some work to do! ".repeat(20));
            if (i % 1000 == 0){
                System.out.println("Print: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie){}
            }
        }
    }
}
