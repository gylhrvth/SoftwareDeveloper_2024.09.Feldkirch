package Thiemo.week06;

public class EmailRegexakaRegbert {
    public static void main(String[] args) {
        String regex = ("(\\S.*\\S)(@)(\\S.*\\S)(.\\S[a-z]{2,3})");
        String regex2 = ("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");

        /*[a-zA-Z0-9._%+-]+: This part matches the local part of the email, which can include letters, numbers, dots (.), underscores (_), percent signs (%), plus signs (+), and hyphens (-).
        @: Matches the @ symbol.
        [a-zA-Z0-9.-]+: Matches the domain part, allowing letters, numbers, dots (.), and hyphens (-).
        \\.: Matches a literal dot (.).
        [a-zA-Z]{2,}: Matches the top-level domain (TLD) part (e.g., com, org, etc.), which must have at least 2 characters.
        This regex will match common email formats, but keep in mind that email validation can get complex because the full range of valid email formats is much broader than this simple regex.*/

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
