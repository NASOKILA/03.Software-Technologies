import java.util.Scanner;

public class SumTwoNumbers {

    public static void main(String[] args) {
        // Za da chetem ot konzolata trqbva da polzvame edno neshto narecheno Scanner
        // TRQBVA DA GO IMPORTNEM, AKO Scanner E S CHERVENO NAPISANO NATISKAME ALT + ENTER
        // I ni se otvarq prozorec ot kudeto da go importnem TRQBVA NI java.util I NI SE
        // POQVQVA OTGORE import java.util.Scanner
        // KAKTO V C# TRQBVA DA IMPORTVAME KLASOVE ZA DA IMAME DOSTUPI


        Scanner scanner = new Scanner(System.in);
        // V skobite mu kazvame OT KUDE DA CHETE, v sluchaq da chete ot standarniq
        // vhod, t.e. OT KONZOLATA !    NO MOJE I DA CHETE OT DRUGI MESTA !!!
        // SKENERA VAJI SAMO ZA METODA V KOITO E SUZDADEN, MOJEM DA GO KRUSTIM KAKTO SI ISKAME !

        // V Java Integer.parseInt() e ekvivalentno na int.Parse() v C# !!!!!
        //Double.parseDouble() E KATO double.Prse() !!!!
        //scanner.nextLine() e kato console.ReadLine() v C# !!!
        double firstNum = Double.parseDouble(scanner.nextLine());
        double secondNum = Double.parseDouble(scanner.nextLine());

        double sum = firstNum + secondNum;


        // S Place holdera mojem da formatirame kakto si poiskame
        //Trqbva da e .printf() za da raboti.
        System.out.printf("Sum = %.2f", sum);

        //VAJNO !!! :
        // V Java nqma decimal, Ima BigInteger, BigDecimal i dr
        // BigInteger e Cqlo chislo koeto e golqmo kolkoto ni subira pametta !
        // BigDecimal e DROBNO CHISLO koeto e golqmo kolkoto ni subira pametta !
    }

}
