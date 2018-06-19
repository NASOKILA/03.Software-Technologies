import java.util.Arrays;
import java.util.Scanner;

public class SymetricNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= num;i++)
        {
            boolean isSymmetric = symmetric(i);
            if(isSymmetric)
            {
                System.out.println(i);
            }
        }


    }

    private static boolean symmetric(int number) {

/*
* 1. copy number into temp
  2. convert temp to a String, and reverse it (tmpStr)
  3. convert tmpStr back to an integer (reversedInt)
  4. compare number and reversedInt for equality
* */

    int temp = number;
    String tempStr = Integer.toString(temp);
    tempStr = new StringBuilder(tempStr).reverse().toString();
    int reversedInt = Integer.parseInt(tempStr);

    if(number == reversedInt)
        return  true;


        return false;
    }
}
