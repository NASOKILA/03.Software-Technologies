import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numsStr = scanner.nextLine()
                .split("\\s");

        Integer[] nums = new Integer[numsStr.length];

        for (int i = 0; i < nums.length; i++)
        {
            nums[i] = Integer.parseInt(numsStr[i]);
        }


        boolean indexExists = false;
        for (Integer num : nums) {

            // get sum of all numbers on the left:
            // get sum of all numbers on the right:

            int index = Arrays.asList(nums).indexOf(num);

            int leftSum = 0;
            for (int i = 0;i < index; i++)
            {
                int currentNum = nums[i];
                leftSum += currentNum;
            }

            int rightSum = 0;
            for (int i = index+1;i < nums.length; i++)
            {
                int currentNum = nums[i];
                rightSum += currentNum;
            }

            if(leftSum == rightSum)
            {
                System.out.println(index);
                indexExists = true;
                break;
            }

        }

        if(!indexExists)
            System.out.print("no");

    }
}


