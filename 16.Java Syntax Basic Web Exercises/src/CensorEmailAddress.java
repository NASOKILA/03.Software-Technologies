import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CensorEmailAddress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String email = scanner.nextLine();
        String[] emailStr = email.split("\\@");

        String userPart = emailStr[0];
        String domainPart = emailStr[1];

        int userPartlength = userPart.toCharArray().length;

        String replacement = "";
        for (int i = 0; i < userPartlength; i++)
        {
            replacement += "*";
        }

        replacement += "@";
        replacement += domainPart;


        //pesho.peshev@email.bg

        String text = scanner.nextLine();

        //Pattern p = Pattern.compile("pesho.peshev@email.bg");   // the pattern to search for
        text = text.replaceAll(email, replacement);

        System.out.println(text);
    }
}
