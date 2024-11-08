package Akif_Malik.ZOO;

public class Tiere {

    private String name;

    private String description;

    public Tiere(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return name + ", " + description;
    }
}
