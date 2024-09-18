package Furkan.week02;

public class TeilenHerrschen {
    public static void main(String[] args) {
        int start = 0;
        int end = 20;
        int num = 5;
        double d = 5.0;

       // System.out.println();
        dividebynummber(start, end, num, d);
        //System.out.println();


    }

    public static void dividebynummber(int start, int end, int num, double d) {
        for (int i= start = 0; start <= end; start++) {
            System.out.printf("%d / 5= ", start);
            System.out.println(start / num);
            System.out.printf("%d / 5.0= ", start);
            System.out.println(start /d);

        }

    }
}

