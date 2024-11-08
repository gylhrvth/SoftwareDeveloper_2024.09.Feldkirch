package Furkan.week09.Zoo;

public class Gehege {
    private String name;
    private String info;

    public Gehege(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public void printInfo(){
        System.out.println("Gehege: " + name + ";" + info);

    }

}
