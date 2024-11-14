package Erik.week09.Konstruktor_Overload;

public class Member {

    // Attribute
    private String name;
    private int age;
    private String email;
    private int id;


    // Konstruktoren
    public Member(String name, int age, String email, int id) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.id = id;
    }

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Member(String email) {
        this.email = "Empty";
    }


    // Getter - Setter
    public String getEmail() {
        return email;
    }


    // Methoden
    public void testPrint() {
        System.out.println("Hallo, ich bin ein Test Print!");
    }

    public void testPrint(int size) {
        System.out.println("Hallo, ich bin ein Test Print mit einer Größe!");
    }

}