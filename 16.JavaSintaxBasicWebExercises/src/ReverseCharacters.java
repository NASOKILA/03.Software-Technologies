import java.util.Scanner;

public class ReverseCharacters {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = "";
        for(int i = 0; i < 3; i++)
        {
            String ch = scanner.nextLine();
            str += ch;
        }

        String result = new StringBuilder(str).reverse().toString();
        System.out.println(result);
    }

}
