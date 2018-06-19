import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class ChangeToUppercase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        String test = scanner.nextLine();
        String patternStr = "(<upcase>([a-zA-Z0-9\\.\\s\\,\\:\\;\\!\\?]+)<\\/upcase>)+";

        Pattern  pattern = Pattern.compile(patternStr);
        Matcher regexMatcher = pattern.matcher(test);

        //TAKA ITERIRAME PO VSICHKI MATCHOVE :
        while (regexMatcher.find()) {

                // VZIMAME SI NUJNATA GRUPA
                String fullMatch = regexMatcher.group(1);

                String match = regexMatcher.group(2);

                // PRAVIM SI REPLACEMENT DA E S GOLQMA BUKVA
                String replacement = match.toUpperCase();



                //NAKRAQ ZAMESTVAME V TEXTA

                test = test.replace(fullMatch,replacement);
        }

        System.out.println(test);



    }
}
