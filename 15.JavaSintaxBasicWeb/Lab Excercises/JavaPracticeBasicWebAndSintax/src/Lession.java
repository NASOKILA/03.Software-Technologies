import java.lang.reflect.Array;
import java.util.*;

public class Lession {

    public static void main(String[] args){

        System.out.println("Hello Java");
        String s = "Pesho";
        System.out.printf("Zdravei %s", s); // TRQBVA DA E .printf() INACHE NQMA DA STANE

        // System.lineSeparator(); // E NOV RED

        // Switch Case E SUSHTIQ SAMO DETO RABOTI NE RABOTI S FLOAT I DOUBLE, MOJE SAMO S
        // char,byte, short, int, string i enum,

        // IF i  ELSE sa sushtite


        //Cikli: ABSOLUTNO EDNI I SUSHTI SA KATO V C#, SAMO FOREACH IMA MALKA RAZLIKA V SINTAKSISA.
/**
 *
    TAKA OBHOJDAME CELIQT PODREDEN RECHNIK PO KVP
 Ako POLZVAME treeMap.keySet() SHTE BUDE PO KLUCHOVE
 AKO POLZVAME treeMap.values() SHTE ITERIRAME PO STOINOSTI :


 * for(Map.Entry<String,Integer> entry : treeMap.entrySet()) {
 String key = entry.getKey();
 Integer value = entry.getValue();

 System.out.println(key + " => " + value);
 }
 */


        System.out.println(System.lineSeparator()); // TOVA E NOV RED


        //STRINOVE:
        /*POCHTI SUSHTITE SA.
                Ima malka razlika;
        */

        //Primer:
        String greet = "Hello";
        char ch = greet.charAt(0);
        System.out.println(ch);

        /*
        ZA DA VZEMEM NEKOI ELEMENT V JAVA TRQBVA DA POLZVAME METOD greet.charAt(index)
        DOKATO V C# Prosto pishem greet[index]

        V JAVA MOJEM DA KAJEM NA EDIN STRING CHE E null ZAHTOTO TUK STRINGA E OBEKT !
        */

        String a = null;

        /*
        VAJNO!!!!!!!!!!!!!!!!! :
        STRINGOVETE KAKTO V C# SA IMMUTABLE T.E. NE MOGAT DA SE PROMENQT, KATO KONKATENIRAME POLUCHAVAME NOV STRING !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        */


        // imame charAt(), contains, toLowerCase(), toUpperCase(), toCharArray() i dr.

        // .toString() SE POLZVA TAKA:
        int num = 5;
        String strNum = Integer.toString(num);
        System.out.println(strNum);

        // indexOf() i lastIndexOf() sa si sushtite
        String name = "Atanas";
        int firstIndex_a = name.indexOf('a');
        int lastIndex_a = name.lastIndexOf('a');

        System.out.println(firstIndex_a);
        System.out.println(lastIndex_a);

        // substring si e sushtiq

        String pieceOfName = name.substring(1,4);
        System.out.println(pieceOfName);


        // Ima .replace() I  replaceAll() koeto raboti sus REGEX:

        String naskoName = "Atjnjs Kjmbitov";
        String naskoNameRefactured = naskoName.replaceAll("j", "a");
        System.out.println(naskoNameRefactured);



        // StringBuildera E POCHTI SUSHTIQ, IMA APPEND

        StringBuilder sb = new StringBuilder();

        sb.append("Nasko, ");
        sb.append("Asi, ");
        sb.append("Toni");

        System.out.println(sb);


        //VAVNO!!!!!!!!!!!!!!!!!!!!! :
        // String.join() raboti samo sus stringove !!!!
        // NO AKO IMAME MASIV Ot INTOVE I ISKAME DA GI OPECHATAME MOJEM DA NAPRAVIM SLEDNOTO:

        int[] numsArr = {1,2,3,4};
        String numsArrInString = Arrays.toString(numsArr);
        System.out.println(numsArrInString);  // AVTOMATICHNO NI SLAGA ZAPETAI MEJDU TQH!
        // AKO ISMAE MOJME DA POLZVAME REPLACE ZA DA SI OFORMIM STRINGCHETO KAKTO SI ISKAME!

        numsArrInString = numsArrInString.replace("[", "");
        numsArrInString = numsArrInString.replace("]", "");
        // Zamenihme si '[' I ']' SUS Prazen string
        System.out.println(numsArrInString);

        // AKO PROSTO IMAME MASIV OT STRINGOVE:

        String[] names = {"Nasko", "Asi", "Toni"};
        System.out.println(String.join(" => ",names));



        //KOLEKCII:

        // MASIVI : TE SA SI SUSHTTE
        // List si e ist, set E List bez povtarqemost, map e rechnik
        // TIK MOJEM DA VZIMAME ELEMENTITE PO INDE KAKTO V C#

        String[] arr = {"Naso", "Goshkata", null};
        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);

        // System.out.println(arr[2].length());    // NE MOJEM DA VIKAME METODI NA OBEKTI OT TIP null
        // NO MOJEM DA IM SETNEM STOINOSTI:

        arr[2] = "Asen";
        System.out.println(arr[2].length());
        // MOJE I S CIKLI DA OBHOZDAME


        // VAJNO!!!:  PRI MASIVITE OSOBENOTO E CHE TRQBVA DA MINAVAME PREZ KLASA Arrays !!!!!!!!!!!!!!!!
        // V DRUGITE KOLEKCII NE E TAKA.


        //SPISUCI:

        // SUZDAVA SE TAKA:  VINAGI TIPUT S GOLQMA BUKVA !!!!!!!
        ArrayList<String> namesList = new ArrayList<String>();

        // MOJEM DA DOBAVQME:
        namesList.add("Nasko");
        namesList.add("Asi");

        // MOJEM DA POLZVAME add KATO insertAt() V C#, t.e. NA DADEN INDEX NI SLAA DADENA STOINOST!
        namesList.add(1,"Toni");
        namesList.add(0,"Toshko");

        System.out.println(namesList); // Toshko, Nasko, Toni, Asi

        //MOJEM DA PREMAHVAME:
        namesList.remove(0); // CHREZ INDEX !!!!!
        namesList.remove("Toni"); // CHREZ IME NA ELEMENTA

        System.out.println(namesList); // Asi Toshko

        // SUZDAVAME SI NOV SPISUK KOITO DA DOBAVIM KUM PURVIQ:
        ArrayList<String> namesToAdd = new ArrayList<String>();
        namesToAdd.add("Miha");
        namesToAdd.add("Bobi");

        //addRange() tuk e addAll()
        namesList.addAll(namesToAdd);

        System.out.println(namesList); // Asi, TOshko, Miha, Bobi

        // VAJNO !!!!!!! :
        // toList() E asList() !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // SPISUCITE SI IMAT FOREACH, SIZE, indexOf(), isEmpty() I MNOGO DRUGI !


        // Kak se izvikvat elementi :
        // V C# E TAKA namesList[1]; V JAVA SE POLZVA METODA .get()

        System.out.println(namesList.get(0)); // DAVA NI PURVIQT ELEMENT


        // .foreach()
        namesList.forEach(e -> System.out.print(e)); // POLZVA SE  ->  VMESTO  =>

        // MNOGO VAJNO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!   :
        // AKO NESTO SVETI V JULTO ZNACHI MOJE DA BUDE SUKRATENO, DAVAME ALT + ENTER I VIJDAME KAK !!!
        namesList.forEach(System.out::print); // TAKA IZGLEJDA KATO GO REPLEISNEM !!!!!


        // MOJEM DA POLZVAME .forEach() FUNKCIQ:
        namesList.forEach(e -> {
            // MOJEM DA SI PISHEM TUK KAKVOTO SI ISKAME!!
            System.out.println("Hello, ");
            System.out.println(e);
        });


        // SETOVE:
        // NE POZVOLQVAT REPETICIQ !!!!!
        // IMA DVA VIDA: HashSet<>  I ThreeSet<>
        // RAZLIKATA E CHE ThreeSet<> DURJI ELEMENTITE SORTIRANI


        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Nasko");
        treeSet.add("Toshko");
        treeSet.add("Tato");
        treeSet.add("Tato");
        treeSet.add("Tato");
        treeSet.add("Baba");
        treeSet.add("Asi");
        treeSet.remove("Nasko");

        System.out.println(treeSet); // VSICHKO E SORTIRANO I NQMA POVTORENIQ

        //AKO E S HashSet SHTE SA PODREDENI PO DRUG NACHIN, SHTE SA RAZBIRKANI !
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Nasko");
        hashSet.add("Toshko");
        hashSet.add("Tato");
        hashSet.add("Tato");
        hashSet.add("Tato");
        hashSet.add("Baba");
        hashSet.add("Asi");
        hashSet.remove("Nasko");

        System.out.println(hashSet); // POLUCHAVAME GI RAZBURKANI PO NEGOV SI NACHIN !



        // MAPOVE:
        // TOVA SA RECHNICI, V C# IMAME DICTIONARY I SortedDictionary
        //V Java imame HashMap<k,v>   i  TreeMap<k,v>

        HashMap<String, Integer> nameAge = new HashMap<>();
        nameAge.put("Nasko", 24);
        nameAge.put("Asi", 25);
        nameAge.put("Toni", 23);

        System.out.println(nameAge);
        // POLUCHAVAME {Toni=23, Asi=25, Nasko=24}, RAZDELENI SA SUS '=' I ','!
        // POLUHAVAME GI RAZBURKANI PO NEGOV SI NACHIN !

        // AKO BESHE SUS TreeMap :
        TreeMap<String, Integer> nameAgeTree = new TreeMap<>();
        nameAgeTree.put("Nasko", 24);
        nameAgeTree.put("Asi", 25);
        nameAgeTree.put("Toni", 23);

        System.out.println(nameAgeTree); // POLUCHAVAME GI SORTIRNI !!!




        // AKO IMAME SPISUK KATO VTORA STOINOST
        HashMap<String, ArrayList<Integer>> namePoints = new HashMap<>();

        // PURVO SI PRAVIM KLUCH( IME ) I STOINOST ( SPISUK )
        namePoints.put("Nasko", new ArrayList<>());

        //POSLE SI DOBAVQME STOINOSTITE KOITO ISKAME DA IMA V SPISUKA !
        // S get se vzima klucha !!!!!!!
        namePoints.get("Nasko").add(24);
        namePoints.get("Nasko").add(25);
        namePoints.get("Nasko").add(26);

        // VRUSHTA NI {Nasko=[24, 25, 26]}
        System.out.println(namePoints);



        // ITERIRANE NA Map PO KLUCHOVE, PO STOINOSTI, I PO DVETE:
        // SHTE RABOTIM S nameAgeTree :
        for (String key : nameAgeTree.keySet()) {
            System.out.println(key);
        }

        System.out.println("---------------------------");
        for (Integer value : nameAgeTree.values()) {
            System.out.println(value);
        }

        System.out.println("---------------------------");
        for (Map.Entry<String,Integer> kvp : nameAgeTree.entrySet()) {
            System.out.println(kvp);
        }
        System.out.println("---------------------------");



        // CHETI KOMENTARITE OT DRUGITE FAILOVE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    }
}

