package Furkan.week10.Konstruktor;

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

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Member (){
        this.email = "empty";
    }

    public String getEmail(){
        return email;
    }




}
