package Erik.week09.Konstruktor_Overload;

public class KonstruktorMain {
    public static void main(String[] args) {

        Member erik = new Member("Erik", 23, "erik-1@gmx.at", 42);
        Member david = new Member("David", 26);
        Member blank = new Member("");

        System.out.println("─".repeat(50));
        System.out.println("Get Mail from Erik: >> " + erik.getEmail());
        System.out.println("Get Mail from David: >> " + david.getEmail());      // Oben nicht definiert
        System.out.println("Get Mail from Blank: >> " + blank.getEmail());      // Im Konstruktor als empty definiert doesn't matter if it's set in the object
        System.out.println("─".repeat(50));
        erik.testPrint();
        System.out.println("─".repeat(50));
        erik.testPrint(20);
        System.out.println("─".repeat(50));
    }
}
