package Sandro.Week9.Vererbung.Konstuktor;


public class Main {
    public static void main(String[] args) {


        Member sandro = new Member("Sandro", 12, "killer@gamil.com", 9);
        Member stany = new Member("Stany", 18);
        Member blank = new Member();


        System.out.println(sandro.getEmail());
        System.out.println(stany.getEmail());
        System.out.println(blank.getEmail());
        System.out.println();
        sandro.test();


    }
}
