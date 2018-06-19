import java.util.*;

public class PhonebookUpgrade {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TreeMap<String, String> phoneBook = new TreeMap<String, String>();

        String[] input = scanner.nextLine().split("\\s");

        while(!input[0].equals("END"))
        {
            String command = input[0];


            if(command.equals("ListAll"))
            {
                for (Map.Entry<String, String> kvp : phoneBook.entrySet()) {
                    System.out.println( kvp.getKey() + " -> " + kvp.getValue());
                }
            }

            if(command.equals("A"))
            {
                String name = input[1];
                String number = input[2];


                phoneBook.put(name,number);

            }
            else if(command.equals("S"))
            {

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


    }

}
