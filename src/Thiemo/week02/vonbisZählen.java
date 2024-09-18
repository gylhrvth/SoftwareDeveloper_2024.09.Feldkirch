package Thiemo.week02;

import Sandro.Colors;

public class vonbisZählen {
        public static void main(String[] args) {

            float start = 0;
            int end = 100;

            System.out.println("===============================");
            System.out.println("=====     von 0 - 100     =====");
            System.out.println("===============================");
            vonbis(0, 100);

        }

        public static void vonbis(float start, int end) {
            for (start = 0.0f; start <= end; start += 0.1f) {
                System.out.printf("Result 1 digit = %-5.1f \n", start);
                System.out.printf("Result 2 digit = %-5.2f \n", start);
                System.out.println(Sandro.Colors.COLORS[6]+"=========================="+ Colors.RESET);
            }
        }
    }




