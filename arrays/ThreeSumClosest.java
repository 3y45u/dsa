package arrays;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {

        int res = threeSumClosest(new int[]{0,0,0}, 1);

        System.out.println(res);

    }

    public static int threeSumClosest(int[] nums, int target) {

        int closestSum = Integer.MAX_VALUE;

        int n = nums.length;

        Arrays.sort(nums);

        for (int k = 0; k < n - 2; k++) {

            int i = k + 1;
            int j = n - 1;

            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];

                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }

                if (sum < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        return closestSum;
    }

}
