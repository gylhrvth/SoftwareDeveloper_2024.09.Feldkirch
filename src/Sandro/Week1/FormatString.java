package Sandro.Week1;

public class FormatString {
    public static void main(String[] args) {

        // System.out.printf("%12.1f\n", 10.5);
        // System.out.printf("%6.2f\n", 10.5);
        // System.out.printf("%-6.2f\n", 9.1845645646);
        // System.out.println();
        // System.out.printf("%2d#  %10d  \n",12 ,258 );
        // System.out.printf("%2d#  %10d  \n",1 ,2580000 );
        // System.out.println();
        // System.out.printf("%10s \n" ,"Test");
        // System.out.printf("%10s \n" ,"Testlauf");
        // System.out.printf("%-10s %13s \n" ,"Testlauf","Hallo");


        for (int i = 1; i < 200;  i= i+19) {
            //System.out.println(i);
            //System.out.printf("%3d\n", i);
            System.out.printf("%3d --> %10s \n", i,"test");
        }
    }
}
