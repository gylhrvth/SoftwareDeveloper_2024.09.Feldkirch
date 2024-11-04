package Gyula.week07.home;

public class Home {
    private String address;
    private int countInhabitants;

    public Home(String address){
        this.address = address;
        countInhabitants = 0;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        if (address.length() > 3) {
            this.address = address;
        } else {
            System.out.println("Ungültige Adresse, wird nicht angenommen");
        }
    }

    @Override
    public String toString() {
        return "Ich ein Home in " + address;
    }

}
