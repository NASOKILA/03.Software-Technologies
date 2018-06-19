import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SumsByTown {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());


        TreeMap<String, Double> townAndIncome = new TreeMap<>();
        for(int i = 0; i < num; i++)
        {
            String[] input = scanner.nextLine().split("\\|");
            String town = input[0].trim();
            Double income  = Double.parseDouble(input[1].trim());

            if(townAndIncome.containsKey(town))
            {
                income += townAndIncome.get(town);
            }
            townAndIncome.put(town,income);


        }


        printResult(townAndIncome);
    }


     public static void printResult(TreeMap<String, Double> townAndIncome){

         for (Map.Entry<String, Double> kvp : townAndIncome.entrySet()) {
             System.out.println(kvp.getKey() + " -> " + kvp.getValue());
         }
     }


}
