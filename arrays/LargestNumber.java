package arrays;

import java.util.Arrays;

public class LargestNumber {

    public static String largestNumber(int[] nums) {

        Integer[] ar = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ar[i] = nums[i];
        }

        Arrays.sort(ar, (i, j) -> {
            String a = Integer.toString(i);
            String b = Integer.toString(j);

            return (b + a).compareTo(a + b);
        });

        StringBuilder sb = new StringBuilder();

        if (ar[0] == 0) {
            return "0";
        }

        for (int i : ar) {
            sb.append(i);
        }

        return sb.toString();

    }
}
