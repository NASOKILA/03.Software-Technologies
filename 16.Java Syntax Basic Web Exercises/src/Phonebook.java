import java.util.*;

public class Phonebook {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> phoneBook= new HashMap<String, String>();

        String[] input = scanner.nextLine().split("\\s");
       // ArrayList<String> searchedNames = new ArrayList<>();



        while(!input[0].equals("END"))
        {
            String command = input[0];
            if(command.equals("A"))
            {
                String name = input[1];
                String number = input[2];


                phoneBook.put(name,number);

            }
            else if(command.equals("S")) {

                String name = input[1];
                if (phoneBook.containsKey(name)) {
                    String phone = phoneBook.get(name);
                    System.out.println(name + " -> " + phone);
                }
                else
                {
                    System.out.println("Contact " + name + " does not exist.");
                }
            }


            input = scanner.nextLine().split("\\s");

        }

       /* for (String searchedName : searchedNames) {
            if(phoneBook.containsKey(searchedName))
            {
                System.out.println(searchedName + " -> " + phoneBook.get(searchedName));
            }
            else
            {
                System.out.println("Contact " + searchedName + " does not exist.");
            }
        }
        */


    }
}
