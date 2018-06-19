import java.util.Scanner;

public class IntegerToHexAndBinary {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Integer num = Integer.parseInt(scanner.nextLine());

        String hex = Integer.toHexString(num).toUpperCase();
        System.out.println(hex);

        String binary = Integer.toBinaryString(num);
        System.out.println(binary);


    }
}
