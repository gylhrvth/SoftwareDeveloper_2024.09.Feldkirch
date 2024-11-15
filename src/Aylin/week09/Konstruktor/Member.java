package Aylin.week09.Konstruktor;

public class Member {
    private String name;
    private int age;
    private String eMail;
    private int id;

    public Member(String name, int age, String eMail, int id){
        this.name = name;
        this.age = age;
        this.eMail = eMail;
        this.id = id;
    }

    public Member(String name, int age){
        this.name = name;
        this.age = age;
        this.eMail = "empty";
    }

    public Member(){
        this.eMail = "empty";
    }

    public String geteMail() {
        return eMail;
    }

    public void test(){
        System.out.println("I am a test");
    }

    public void test(int size){
        System.out.println("I am a test with size");
    }
}
