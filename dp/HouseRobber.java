package dp;

import java.util.Arrays;

public class HouseRobber {

    static int[] mem;

    public static void main(String[] args) {

    }

    public static int rob(int[] nums) {

        int n = nums.length;

        Arrays.fill(mem, -1);

        return solve(nums, 0, n);
    }

    public static int solve(int[] nums, int i, int n) {
        // i n se badha hua mtlb exhausted all the houses
        if (i >= n) {
            return 0;
        }

        if (mem[i] != -1) {
            return mem[i];
        }

        int steal = nums[i] + solve(nums, i + 2, n);
        int skip = solve(nums, i + 1, n);

        return mem[i] = Math.max(steal, skip);
    }
}
