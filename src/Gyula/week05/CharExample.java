package Gyula.week05;


public class CharExample {
    public static void main(String[] args) {
        char letter = 'a';

        System.out.println(letter);

        for (int i = 0; i < 10; i++) {
            System.out.println(letter + " " + (int)letter + " " + Integer.toHexString(letter));
            ++letter;
        }

        String text = "Hello World!";
        System.out.println(text);
        char[] lettersFromText = text.toCharArray();
        for (int i = 0; i < lettersFromText.length; i++) {
            System.out.println("Buchstabe: " + lettersFromText[i]);
        }

        String name1 = "Aylin";
        String name2 = "Akif";
        String name3 = "Sandro";

        System.out.println(name1 + " compareTo " + name2 + ": " + name1.compareTo(name2));
        System.out.println(name1 + " compareTo " + name3 + ": " + name1.compareTo(name3));


        sayHello("Thiemo".concat(" is the best"));
        sayHello("Thiemo" + " is the best");

        sayHello(3);


        String[] names = new String[]{"Furkan", "Aylin", "Thiemo", "Erik", "Akif", "Sandro", "Gyula" };
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        int indexNames = 0;
        int indexNumber = 0;
        while (indexNames < names.length && indexNumber < numbers.length){
            if (indexNames > 0){
                System.out.print(", ");
            }
            System.out.print(names[indexNames] + ", " + numbers[indexNumber]);
            ++indexNames;
            ++indexNumber;
        }
        while (indexNames < names.length){
            System.out.print(", " + names[indexNames]);
            ++indexNames;
        }
        while (indexNumber < numbers.length){
            System.out.print(", " + numbers[indexNumber]);
            ++indexNumber;
        }
        System.out.println();
    }

    public static void sayHello(int number){
        for (int i = 0; i < number; i++) {
            System.out.println("Hallo!");
        }
    }

    public static void sayHello(String name){
        System.out.println("Hallo " + name + "!");
    }
}
