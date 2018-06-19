import java.util.Arrays;
import java.util.Scanner;

public class CompareCharArrays {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String strOne = scanner.nextLine();
        String strTwo = scanner.nextLine();

        char[] charArrOne = strOne.replaceAll(" ", "").toCharArray();
        char[] charArrTwo = strTwo.replaceAll(" ", "").toCharArray();

        int oneLength = charArrOne.length;
        int twoLength = charArrTwo.length;

        int maxLength = Math.max(oneLength,twoLength);
        int minLength = Math.min(oneLength,twoLength);

        for (int i = 0; i < minLength; i++)
        {
            if(charArrOne[i] < charArrTwo[i])
            {
                System.out.println(charArrOne);
                System.out.println(charArrTwo);
                return;
            }
            else if(charArrOne[i] > charArrTwo[i])
            {
                System.out.println(charArrTwo);
                System.out.println(charArrOne);
                return;
            }

        }

        // They Are both Equal
        if(charArrOne.length == minLength)
        {
            System.out.println(charArrOne);
            System.out.println(charArrTwo);
        }
        else
        {
            System.out.println(charArrTwo);
            System.out.println(charArrOne);
        }

    }
}
