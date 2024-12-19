package arrays;
// https://leetcode.com/problems/minimum-size-subarray-sum/description/

public class MininumSizeSubArray {

    public static void main(String[] args) {

        int ar[] = {1, 1, 1, 1, 1, 1, 1, 1};
        int tag = 12;

        int res = minSubArrayLen(tag, ar);

        System.out.println(res);

    }

    public static int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;

        int i = 0, j = 0;

        int sum = 0;

        int min = Integer.MAX_VALUE;

        while (j < n) {
            sum += nums[j];

            while (sum >= target) {
                min = Math.min(min, j - i + 1);
                sum -= nums[i];
                i++;
            }

            j++;
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
