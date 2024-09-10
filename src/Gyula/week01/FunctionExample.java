package Gyula.week01;

public class FunctionExample {
    public static void main(String[] args) {
        sayHello();
        System.out.println("-----");
        repeatHello(5);
        repeatHello(2);
        System.out.println("-----");
        int summe = addNumber(5, 2);
        System.out.println("Summe = " + summe);
        System.out.println("------");
        sayHelloTo("Gyula", 2);
        sayTo("Guten Morgen,", "Aylin", 100);
    }


    public static void sayHello(){
        System.out.println("Hello!");
    }

    public static void repeatHello(int count){
        for (int i = 0; i < count; i++) {
            System.out.println("Hello!");
        }
    }

    public static int addNumber(int a, int b){
        return a + b;
    }

    public static void sayHelloTo(String name, int count){
        for (int i = 0; i < count; ++i){
            System.out.println("Hello " + name + "!");
        }
    }

    public static void sayTo(String greeting, String name, int count){
        for (int i = 0; i < count; ++i){
            System.out.println(greeting + " " + name + "!");
        }
    }

}
