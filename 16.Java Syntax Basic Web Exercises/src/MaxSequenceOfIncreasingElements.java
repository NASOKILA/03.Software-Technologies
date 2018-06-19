import java.util.Scanner;
import java.util.TreeMap;

public class MaxSequenceOfIncreasingElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s");
        int[] nums = new int[input.length];


        int counter = 0;
        for (String el : input) {
            nums[counter] = (Integer.parseInt(el));
            counter++;
        }
        //2 1 1 2 3 3 2 2 2 1



        int len = 1;
        int start = 0;
        int bestStart = -1;
        int bestLength = -1;

        for (int i = 1; i < nums.length; i++)
        {

            if(nums[i-1] == nums[i]-1)
            {
                len++;
            }
            else
            {
                start = i;
                len = 1;
            }

            if(bestLength < len) {
                bestLength = len;
                bestStart = start;
            }


        }


        for(int i = bestStart; i < bestStart + bestLength; i++)
        {
            System.out.print(nums[i] + " ");
        }


        //2 1 1 2 3 3 2 2 2 1
        //1 1 1 2 3 1 3 3

    }


}

