import java.util.Scanner;

public class SumNIntegers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int result = 0;
        for (int i = 0; i < n; i++)
        {
            int num = Integer.parseInt(scanner.nextLine());
            result += num;
        }

        System.out.printf("Sum = %d", result);

    }
}
