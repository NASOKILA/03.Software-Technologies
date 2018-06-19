import java.util.*;

public class ReverseString {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        char[] charStr = str.toCharArray();


        ArrayList<Character> list = new ArrayList<>();

        for (char c : charStr) {
            list.add(c);
        }

        Collections.reverse(list);

        for (Character character : list) {
            System.out.print(character);
        }




    }
}
