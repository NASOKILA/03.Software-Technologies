import java.util.ArrayList;
import java.util.Scanner;

public class FitStringIn20Chars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        char[] charStr = str.toCharArray();



        if(charStr.length < 20) {
            for (int i = 0; i < 20; i++) {
                if(i < charStr.length)
                    System.out.print(charStr[i]);
                else
                    System.out.print("*");
            }
        }
        else
        {
            System.out.print(str.substring(0,20));
        }



    }
}
