import java.util.Scanner;

public class VariableInHexadecimalFormat {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String hex = scanner.nextLine();
        Integer dec = Integer.parseInt(hex,16);

        System.out.println(dec);
    }
}
