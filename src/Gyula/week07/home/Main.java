package Gyula.week07.home;

public class Main {
    public static void main(String[] args) {
        Home home1 = new Home("Feldkirch");
        Home home2 = new Home("Feldkirch");

        home1.setAddress("au");
        System.out.println(home1.getAddress());

        home1.setAddress("Dornbirn");
        //home2.address = "Feldkirch";


        System.out.println(home1.getAddress());
        System.out.println(home2.getAddress());

        System.out.println(home1);
    }

}
