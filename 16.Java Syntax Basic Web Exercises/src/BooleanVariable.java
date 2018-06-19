import java.util.Scanner;

public class BooleanVariable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        Boolean result = Boolean.valueOf(str);
        if(result)
            System.out.println("Yes");
        else
            System.out.println("No");

    }

}
