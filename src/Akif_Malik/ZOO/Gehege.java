package Akif_Malik.ZOO;

import Sandro.Colors;

import java.util.Vector;

public class Gehege {
    private String name;
    private Vector<Tiere> tiere;

    public Gehege(String name) {
        this.name = name;
        this.tiere = new Vector<>();
    }

    public String getName() {
        return name;
    }

    public void addTier(Tiere tier) {
        tiere.add(tier);
    }

    public Vector<Tiere> getAnimals() {
        return tiere;
    }
    @Override
    public String toString () {
        return Colors.COLORS[1] + name + Colors.RESET;
    }
}
