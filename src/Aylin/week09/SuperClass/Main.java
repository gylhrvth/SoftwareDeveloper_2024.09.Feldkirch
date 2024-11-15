package Aylin.week09.SuperClass;

public class Main {
    public static void main(String[] args) {
        System.out.println("Create event");
        Event event = new Event("Halloween Party", "31/10/2025", "Feldkirch");
        System.out.println("****************************");
        System.out.println();

        System.out.println("Create concert");
            Concert concert = new Concert("Seksendört", "15/12/2024", "Dornbirn", "rock");
        System.out.println("****************************");
        System.out.println();
        System.out.println("Create Theater");
            Theater theater = new Theater("The Lion King", "26/04/2024", "Wien", "Dwayne, the Rock, Johnson");
        System.out.println("****************************");
        System.out.println();

        System.out.println("Create Classical Concert");
                ClassicalConcert classic = new ClassicalConcert("Mozart", "17/11/2024", "Helsinki", "classical", "Willi Witzemann");
        System.out.println("****************************");
        System.out.println();
        
    }
}
