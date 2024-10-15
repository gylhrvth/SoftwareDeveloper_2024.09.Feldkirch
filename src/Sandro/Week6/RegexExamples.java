package Sandro.Week6;

public class RegexExamples {
    public static void main(String[] args) {
        String text = "Hallo wie gehts?";

        System.out.println("Ist ein a enthalten? " + text.matches(".*al.*"));

        text = "babababababababababababab";

        //Genau ab 1 bis unendlich
        System.out.println(text.matches("(ab)+"));

        //NUR Großbuchstaben 1 bis unendlich
        text = "ABCADFASDFASBHJASJLDFHALSDKFHJASLKDF";
        String textFalse = "aslkdfjalskdfjalskfjalskdjfalsdkjfasldkfjAlaksjfalksjf";
        String regex = "[A-Z]+";
        System.out.println("Wahr: " + text.matches(regex));
        System.out.println("Unwahr: " + textFalse.matches(regex));

        System.out.println("---");

        //Nur Zahlen, genau 3 bis 8 Stück
        text = "12345";
        textFalse = "21";
        String textFalse2 = "214478901";
        regex = "[0-9]{3,8}";
        System.out.println("Wahr: " + text.matches(regex));
        System.out.println("Unwahr: " + textFalse.matches(regex));
        System.out.println("Unwahr: " + textFalse2.matches(regex));

        System.out.println("---");

        //Nur Zahlen, 3 bis 8 Stück, beginnend mit 1
        text = "12345";
        textFalse = "221";
        textFalse2 = "114478901";
        regex = "1[0-9]{2,7}";
        System.out.println("Wahr: " + text.matches(regex));
        System.out.println("Unwahr: " + textFalse.matches(regex));
        System.out.println("Unwahr: " + textFalse2.matches(regex));

        //Alle Zahlen außer 1, 1 bis unendlich Stück
        text = "009238098";
        textFalse = "221";
        textFalse2 = "4471890";
        regex = "[02-9]+";
        System.out.println("Wahr: " + text.matches(regex));
        System.out.println("Unwahr: " + textFalse.matches(regex));
        System.out.println("Unwahr: " + textFalse2.matches(regex));

        //Alle Zahlen die nicht mit 1 beginnen, 1 bis unendlich Stück
        text = "009231231380918";
        textFalse = "1221";
        textFalse2 = "104471890";
        regex = "[^1][0-9]+";
        System.out.println("Wahr: " + text.matches(regex));
        System.out.println("Unwahr: " + textFalse.matches(regex));
        System.out.println("Unwahr: " + textFalse2.matches(regex));

        System.out.println("---");

        //Beginnend mit 1 bis unendlich Zahlen,
        // 1 oder kein Buchstabe,
        // die Zahlen 3 bis 5, 1 bis 2 mal,
        // dann ein X
        text = "476189234798743X";
        String text2 = "1X4X";
        textFalse = "A34X";
        textFalse2 = "123A2X";
        regex = "[0-9]+[a-zA-Z]?[3-5]{1,2}X";
        System.out.println("Wahr: " + text.matches(regex));
        System.out.println("Wahr: " + text2.matches(regex));
        System.out.println("Unwahr: " + textFalse.matches(regex));
        System.out.println("Unwahr: " + textFalse2.matches(regex));

        String email = "te5t.test123.test123@test1.t.m";
        String email2 = "test123@test1.com";
        String emailWrong = "1.1@test.com";
        String emailWrong2 = "asdf@test";

        System.out.println("---");

        String regexLetterOrNumber = "[a-zA-Z0-9]";

        String emailBeforeAt = "[^0-9]" + regexLetterOrNumber + "+(\\." + regexLetterOrNumber + "+)*";
        String emailAfterAt = "(" + regexLetterOrNumber + "+\\.)+[a-zA-Z]{2,}";

        regex = emailBeforeAt + "@" + emailAfterAt;
        System.out.println("Wahr: " + email.matches(regex));
        System.out.println("Wahr: " + email2.matches(regex));
        System.out.println("Unwahr: " + emailWrong.matches(regex));
        System.out.println("Unwahr: " + emailWrong2.matches(regex));


    }
}
