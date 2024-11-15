package Sandro.Week9.Vererbung.Konstuktor;

public class Member {
    private String name;
    private int age;
    private String email;
    private int id;

    public Member(String name, int age, String email, int id) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.id = id;
    }
    public Member(String name, int age){
        this.name = name;
        this.age = age;
        this.email = "empty";
    }
    public Member() {
        this.email = "empty";
    }
    public String getEmail() {
        return email;
    }

    public void test(){
        System.out.println("Ich bin ein Test");
    }
    public void test(int size){
        System.out.println("Ich bin ein Test mit size");
    }



}
