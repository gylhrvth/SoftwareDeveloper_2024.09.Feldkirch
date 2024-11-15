package Thiemo.week09.Vererbung.Konsruktor;

public class Member {

    private String name;
    private String gender;
    private int age;
    private String whatever;

    public Member(String name, String gender, int age, String whatever) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.whatever = whatever;
    }

    public Member(String name, String gender) {
        this.name = name;
        this.gender = gender;
        this.whatever = "";

    }

    public Member(String name) {
        this.name = name;
        this.age = 0;
    }

    public int getAge() {
        return age;
    }

    public void test(){
        System.out.println("test");
    }
     public void test(int size){
         System.out.println("test mit size");
     }
}

