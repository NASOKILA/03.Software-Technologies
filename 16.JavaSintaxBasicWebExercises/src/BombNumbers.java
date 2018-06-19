import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BombNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] numsStr = scanner.nextLine()
                .split("\\s");

        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < numsStr.length; i++)
        {
            nums.add(Integer.parseInt(numsStr[i]));
        }


        String[] specialNumAndPower = scanner.nextLine().split("\\s");

        Integer specialNum = Integer.parseInt(specialNumAndPower[0]);
        Integer power = Integer.parseInt(specialNumAndPower[1]);

        for (int i = 0; i < nums.size(); i++) {

            if(nums.get(i) == specialNum)
            {
                // get start index
                // get and burn left numbers


                int stertIndexToRemove =
                        Math.max(0, nums.indexOf(nums.get(i)) - power);


                for (int ii = 0; ii < power; ii++)
                {
                    nums.remove(stertIndexToRemove);

                }

                // BURN NUMBERS FROM THE RIGHT

                int indexOfSpecialNum = nums.indexOf(specialNum);

                int maxNum =
                        Math.min(indexOfSpecialNum + power, nums.size() - 1);


                for (int ii = indexOfSpecialNum-1;ii < maxNum; ii++)
                {
                    nums.remove(indexOfSpecialNum);
                }

                i = i - (power*2);
            }
        }


        // sum the remaining numbers and print them:
        int sum = 0;
        for (Integer n : nums) {
            sum += n;
        }


        System.out.println(sum);

    }
}
