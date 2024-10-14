package Furkan.week05;

/* Todo:
1: int[] bauen.
2.char einfügen


 */

public class BuchstabenZählen {
    public static void main(String[] args) {
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i]= i;
        }
        for (int number : numbers){
            System.out.println("int[" +number + "]");
        }
        String text = "Hallo Furkan";

        char[] lettersFromText = text.toCharArray();
        for (int i = 0; i < lettersFromText.length; i++) {

            System.out.println("Buchstabe: " + lettersFromText);

        }

       // String randomText = data.Texts.getSimpleText();
       // System.out.println(randomText);

    }


     public static void createArray(){
         int[] numbers = new int[100];
         for (int i = 0; i < numbers.length; i++) {
             numbers[i] = i;
         }for (int number : numbers) {
             System.out.println("int[" + number + "]");
         }

     }








}
