import java.util.Scanner;

public class URLParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("://");

        if(input.length == 1)
        {
            // ako nqma protokol
            String[] restOfInput = input[0].split("/");


            // split by '/'
            // check the length
            if(restOfInput.length == 1)
            {
                // ako nqma resourse NACHI IMA SAMO SERVER

                // vzimame si servera I GO PRINTIRAME
                String server = restOfInput[0];

                System.out.println("[protocol] = \"\"");
                System.out.println("[server] = " + "\"" + server + "\"");
                System.out.println("[resource] = \"\"");
            }
            else
            {
                // ako ima resourse

                // vzimame si servera
                String server = restOfInput[0];

                // vzimame si resourses chrez cikul
                String resourses = "";
                for (int i = 1; i < restOfInput.length;i++)
                {
                    resourses += restOfInput[i] + "/";
                }

                // mahame polsedniq element koito e '/'
                resourses = resourses.substring(0, resourses.length() - 1);


                System.out.println("[protocol] = \"\"");
                System.out.println("[server] = " + "\"" + server + "\"");
                System.out.println("[resource] = " + "\"" + resourses + "\"");

            }


        }
        else
        {
            //ako ima protokol

            // vzimame protokola
            String protocol = input[0];

            // split by '/'
            String[] restOfInput = input[1].split("/");

            // check the length
            if(restOfInput.length == 1)
            {
                // ako nqma resourse NACHI IMA SAMO SERVER I PROTOKOL

                // vzimame si servera I GO PRINTIRAME ZADNO S PROTOKOLA
                String server = restOfInput[0];

                System.out.println("[protocol] = " + "\"" + protocol + "\"");
                System.out.println("[server] = " + "\"" + server + "\"");
                System.out.println("[resource] = \"\"");
            }
            else
            {

                // ako ima resourse

                // vzimame si servera
                String server = restOfInput[0];

                // vzimame si resourses chrez cikul
                String resourses = "";
                for (int i = 1; i < restOfInput.length;i++)
                {
                    resourses += restOfInput[i] + "/";
                }

                // mahame polsedniq element koito e '/'
                resourses = resourses.substring(0, resourses.length() - 1);


                System.out.println("[protocol] = " + "\"" + protocol + "\"");
                System.out.println("[server] = " + "\"" + server + "\"");
                System.out.println("[resource] = " + "\"" + resourses + "\"");


            }

        }


    }
}
