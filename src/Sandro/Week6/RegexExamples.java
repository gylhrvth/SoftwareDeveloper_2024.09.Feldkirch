package Sandro.Week6;

public class RegexExamples {
    public static void main(String[] args) {

        System.out.println("String Regex");
        String test1 = "sandro";
        String test2 = "Sandro";
        String regex = "[A-Z][a-z]+";

        System.out.println(test1.matches(regex));
        System.out.println(test2.matches(regex));

        System.out.println("Number Regex");
        String numb1 = "1234";
        String numb2 = "233456";
        String numb3 = "7";
        String numb4 = "";

        String regex2 = "[0-7]";
        System.out.println(numb1.matches(regex2));
        System.out.println(numb2.matches(regex2));
        System.out.println(numb3.matches(regex2));
        System.out.println(numb4.matches(regex2));

        System.out.println(numb2);
        String test = numb2.replaceAll("[3-4]","H");

        System.out.println(test);






    }

    public static void regexStuff (){
        //Ist ein al im Text enthalten?
        String text = "Hallo wie gehts?";
        System.out.println(text);
        System.out.println("Ist ein (al) enthalten? --> " + text.matches(".*al.*"));
        System.out.println("#".repeat(50));

        //Genau ab 1 bis unendlich
        text = "ababababababababababababab";
        System.out.println(text);
        System.out.println("Text mit genau (ab) einmal, oder unendlich --> "+text.matches("(ab)+"));
        System.out.println("#".repeat(50));


        //NUR Großbuchstaben 1 bis unendlich
        text = "ABCADFASDFASBHJASJLDFHALSDKFHJASLKDF";
        System.out.println("Text 1 = "+text);
        String textFalse = "aslkdfjalskdfjalskfjalskdjfalsdkjfasldkfjAlaksjfalksjf";
        System.out.println("Text 2 = "+textFalse);
        String regex = "[A-Z]+";
        System.out.println("Text1 besteht nur aus Großbuchstaben? --> " + text.matches(regex));
        System.out.println("Text2 besteht nur aus Großbuchstaben? --> " + textFalse.matches(regex));
        System.out.println("#".repeat(50));


        //Nur Zahlen, genau 3 bis 8 Stück
        text = "12345";
        System.out.println("Text1 = "+text);
        textFalse = "21";
        System.out.println("Text2 = "+textFalse);
        String textFalse2 = "214478901";
        System.out.println("Text 3 = "+textFalse2);
        regex = "[0-9]{3,8}";
        System.out.println("Text1 besteht aus zahlen, mind 3 und max 8 --> " + text.matches(regex));
        System.out.println("Text2 besteht aus zahlen, mind 3 und max 8 --> " + textFalse.matches(regex));
        System.out.println("Text3 besteht aus zahlen, mind 3 und max 8 --> " + textFalse2.matches(regex));

        System.out.println("#".repeat(50));

        //Nur Zahlen, 3 bis 8 Stück, beginnend mit 1
        text = "12345";
        textFalse = "221";
        textFalse2 = "114478901";
        regex = "1[0-9]{2,7}";
        //System.out.println("Wahr: " + text.matches(regex));
        //System.out.println("Unwahr: " + textFalse.matches(regex));
        //System.out.println("Unwahr: " + textFalse2.matches(regex));
        System.out.println("#".repeat(50));
        //Alle Zahlen außer 1, 1 bis unendlich Stück
        text = "009238098";
        textFalse = "221";
        textFalse2 = "4471890";
        regex = "[02-9]+";
        //System.out.println("Wahr: " + text.matches(regex));
        //System.out.println("Unwahr: " + textFalse.matches(regex));
        //System.out.println("Unwahr: " + textFalse2.matches(regex));
        System.out.println("#".repeat(50));
        //Alle Zahlen die nicht mit 1 beginnen, 1 bis unendlich Stück
        text = "009231231380918";
        textFalse = "1221";
        textFalse2 = "104471890";
        regex = "[^1][0-9]+";
        //System.out.println("Wahr: " + text.matches(regex));
        //System.out.println("Unwahr: " + textFalse.matches(regex));
        //System.out.println("Unwahr: " + textFalse2.matches(regex));
        System.out.println("#".repeat(50));

        //Beginnend mit 1 bis unendlich Zahlen,
        // 1 oder kein Buchstabe,
        // die Zahlen 3 bis 5, 1 bis 2 mal,
        // dann ein X
        text = "476189234798743X";
        String text2 = "1X4X";
        textFalse = "A34X";
        textFalse2 = "123A2X";
        regex = "[0-9]+[a-zA-Z]?[3-5]{1,2}X";
        //System.out.println("Wahr: " + text.matches(regex));
        //System.out.println("Wahr: " + text2.matches(regex));
        //System.out.println("Unwahr: " + textFalse.matches(regex));
        //System.out.println("Unwahr: " + textFalse2.matches(regex));

        String email = "te5t.test123.test123@test1.t.m";
        String email2 = "test123@test1.com";
        String emailWrong = "1.1@test.com";
        String emailWrong2 = "asdf@test";

        System.out.println("#".repeat(50));

        String regexLetterOrNumber = "[a-zA-Z0-9]";

        String emailBeforeAt = "[^0-9]" + regexLetterOrNumber + "+(\\." + regexLetterOrNumber + "+)*";
        String emailAfterAt = "(" + regexLetterOrNumber + "+\\.)+[a-zA-Z]{2,}";

        regex = emailBeforeAt + "@" + emailAfterAt;
        //System.out.println("Wahr: " + email.matches(regex));
        //System.out.println("Wahr: " + email2.matches(regex));
        //System.out.println("Unwahr: " + emailWrong.matches(regex));
        //System.out.println("Unwahr: " + emailWrong2.matches(regex));




    }
}
