package Aylin.week09.Konstruktor;

public class Main {
    public static void main(String[] args) {

        Member aylin = new Member("Aylin", 26, "topcuaylin98@gmail.com", 8);
        Member aygün = new Member("Aygün", 26);
        Member empty = new Member();

        System.out.println(aylin.geteMail());
        System.out.println(aygün.geteMail());
        System.out.println(empty.geteMail());

    }
}
