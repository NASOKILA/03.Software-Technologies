import java.util.Scanner;

public class ThreeIntegerSum
{
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        // Inputa idva kato masiv ot stringove i trqbva da gi splitnem i da parsnem
        // chislata edno po edno.


        // split V JAVA RABOTI S REGEC, TRQBVA DA SE NAPISHE ZADULJITELNO
        String[] numsStringArray = scanner.nextLine().split("\\s+");


        //Pravim si nov int masiv kito da e sus sushtata duljina:
        int[] nums = new int[numsStringArray.length];

        // TRQBVA DA PARSNEM VSICHKI STRINGCHETA V INTEGERI I DA GI DOBAVIM KUM
        // NOVIQ MASIV OT INTEGERI, SHTE GO NAPRAVIM S FOR CIKUL SUS FOR CIUL

        // SHORTCUT ZA CIKLI E : iter ZA FOREACH    I ita ZA FOR

        for (int i = 0; i < numsStringArray.length; i++) {
            int num = Integer.parseInt(numsStringArray[i]);
            nums[i] = num;
        }

        int numOne = nums[0];
        int numTwo = nums[1];
        int numThree = nums[2];


        if(numOne == numTwo + numThree)
        {
            System.out.printf("%d + %d = %d", Math.min(numTwo, numThree), Math.max(numTwo, numThree), numOne);
        }
        else if(numTwo == numOne + numThree)
        {
            System.out.printf("%d + %d = %d", Math.min(numOne, numThree), Math.max(numOne, numThree), numTwo);
        }
        else if(numThree == numOne + numTwo)
        {
            System.out.printf("%d + %d = %d",Math.min(numOne, numTwo), Math.max(numOne, numTwo), numThree);
        }
        else
        {
            System.out.println("No");
        }

    }
}
