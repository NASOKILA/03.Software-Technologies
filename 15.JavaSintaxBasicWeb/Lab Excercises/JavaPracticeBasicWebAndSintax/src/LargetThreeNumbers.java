import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class LargetThreeNumbers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] nums = Arrays
                .stream(scan.nextLine().split(" ")) // CHETEM RED SPLITVAME PO SPACE I STAVA NA MASIV
                .mapToInt(Integer::parseInt) // PARSVAME SI VSEKI ELEMENT
                .toArray();

        //stream() PRAVI POTOK OT DANNI
        //map  VZIMA VESKI EDIN ELEMENT I MU PRILAGA NESHTO

        // VAJNO !!!! : AKO POLZVAME int[] TRQBVA DA POLZVA ME mapToInt()
        // AKO POLZVAME Integer[] MOJEM DA POLZVAME map() NO SI IMA OSOBENOSTI

        // sortirame si masiva !
        // OSOBENOTO NA MASIVITE E CHE TRQBVA VINAGI DA MINAVAME PREZ KLASA Arrays
        // V DRUGITE KOLEKCII NE E TAKA!
        Arrays.sort(nums);

        // countera e minimalnoto mejdu 3 i duljinata na masiva.
        int counter = Math.min(3, nums.length);
        // countera e minimalnoto mejdu 3 i duljinata na masiva.


        for (int i = 0; i < counter; i++)
        {
            int index = nums.length - i - 1;
            System.out.println(nums[index] + " ");
        }


    }
}
