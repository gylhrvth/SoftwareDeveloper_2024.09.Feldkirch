package Erik.week09.Abstrakt;

public class Main {
    public static void main(String[] args) {

        // Objekte
       // FourLegs vier = new FourLegs(" ",0,0,"no","unknown"); kann nicht mehr erstellt wrden weil die Klasse FourLegs abstract wurde

        // Alle klassen die davon erben können immer noch ein objekt erstellen
        FourLegs cat  = new Cat("Mimi",2,4,"yes","orange","miaut");
        FourLegs dog  = new Dog("Bello",5,4,"yes","black","wuff");











    }
}
