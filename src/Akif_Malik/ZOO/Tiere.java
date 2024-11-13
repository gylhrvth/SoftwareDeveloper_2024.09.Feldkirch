package Akif_Malik.ZOO;

import Sandro.Colors;

import java.awt.*;

public class Tiere {

    private String name;

    private String description;

    public Tiere(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return Colors.COLORS[3] + name + ", " + description + Colors.RESET;
    }
}
