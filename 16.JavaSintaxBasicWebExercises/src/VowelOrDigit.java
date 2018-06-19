import java.util.Scanner;

public class VowelOrDigit {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] charArray = str.toCharArray();
        char ch = charArray[0];

        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
        {
            System.out.println("vowel");
        }
        else if(Character.isDigit(ch))
            System.out.println("digit");
        else
            System.out.println("other");


    }

}
