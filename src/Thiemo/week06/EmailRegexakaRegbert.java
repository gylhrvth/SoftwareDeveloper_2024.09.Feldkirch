package Thiemo.week06;

public class EmailRegexakaRegbert {
    public static void main(String[] args) {
        String regex = ("(\\S.*\\S)(@)(\\S.*\\S)(.\\S[a-z]{2,3})");
        String regex2 = ("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");

        System.out.println("alfons@drlue.at".matches(regex));
        System.out.println("rambina.alfons@drlue.at".matches(regex));
        System.out.println("rambina1.1alfons@drlue.at".matches(regex));
        System.out.println("1rambina1.alfons@drlue.at".matches(regex));
        System.out.println("@drlue.at".matches(regex));
        System.out.println("drlue.at".matches(regex));
        System.out.println("asdf@drlue".matches(regex));
        System.out.println("asdf@microsoft.c".matches(regex));
        System.out.println();
        System.out.println("alfons@drlue.at".matches(regex2));
        System.out.println("rambina.alfons@drlue.at".matches(regex2));
        System.out.println("rambina1.1alfons@drlue.at".matches(regex2));
        System.out.println("1rambina1.alfons@drlue.at".matches(regex2));
        System.out.println("@drlue.at".matches(regex2));
        System.out.println("drlue.at".matches(regex2));
        System.out.println("asdf@drlue".matches(regex2));
        System.out.println("asdf@microsoft.c".matches(regex2));
    }
}
