package Sandro.Week9.Vererbung.Rehearsal;

import java.lang.module.ModuleReader;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
       // Fahrzeuge test = new Fahrzeuge(4,"Blau");

        Auto auto = new Auto(4,"schwarz",4);
        Motorad rad = new Motorad(2, "Geld","Bremse");

        auto.startMotor();
        rad.startMotor();

        Vector<Fahrzeuge> list = new Vector<>();
        list.add(auto);
        list.add(rad);
        System.out.println();
        doAll(list);
        System.out.println();
        doCar(auto);
    }
    public static void doAll (Vector<Fahrzeuge> liste){
        for (Fahrzeuge f : liste){
            f.test();
        }
    }

    public static void doCar (Fahrzeuge f){

        if(f instanceof Auto){
            Auto myCar = (Auto)f;
            myCar.test();
            myCar.startMotor();
        }
        else {
            System.out.println("war kein auto");
        }


    }

}
