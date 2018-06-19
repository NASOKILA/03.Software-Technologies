import java.util.Scanner;

public class IndexOfLetters {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        char[] charArray = str.toCharArray();
        for(char c : charArray) {

            int index = c - 97;
            System.out.println(c + " -> " + index);

        }
    }
}
