import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MostFrequentNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numsStr = scanner.nextLine()
                .split("\\s");

        int occurance = 1;

        TreeMap<String, Integer> numStrAndOccurrence = new TreeMap<>();


        for (String num : numsStr) {

            if(!numStrAndOccurrence.containsKey(num))
            {
                // ako ne sudurja tozi string kato kluch
                occurance = 1;
            }
            else
            {
                occurance = numStrAndOccurrence.get(num);
                occurance++;
            }

                numStrAndOccurrence.put(num,occurance);

        }

        int maxValue = -999999;
        for(Map.Entry<String,Integer> kvp: numStrAndOccurrence.entrySet()) {
             if(maxValue < kvp.getValue())
             {
                  maxValue = kvp.getValue();
             }

        }

               String mostFrequentNum = "";

        for (Map.Entry<String,Integer> kvp : numStrAndOccurrence.entrySet()) {
            if(kvp.getValue() == maxValue)
            {
                mostFrequentNum = kvp.getKey();
                break;
            }
        }

        System.out.println(mostFrequentNum);

    }

}
