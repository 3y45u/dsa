package dp;

import java.util.Arrays;

public class MaxAlternatingSubSequenceSum {

    static int n;

    static long[][] dp;

    public static void main(String[] args) {

    }

    public long maxAlternatingSum(int[] nums) {
        n = nums.length;

        dp = new long[100001][2];

        for (long[] ar : dp) {
            Arrays.fill(ar, -1);
        }

        return solve(0, nums, true);// true ka matlab plus
    }

    public static long solve(int idx, int[] nums, boolean flag) {

        if (idx >= n) {
            return 0L;
        }

        int col = flag == true ? 1 : 0;

        if (dp[idx][col] != -1) {
            return dp[idx][col];
        }

        long skip = solve(idx + 1, nums, flag);

        long val = nums[idx];

        if (!flag) {// if flag == false, to value to negative krna padega
            val = -val;
        }
        long take = solve(idx + 1, nums, !flag) + val;

        return dp[idx][col] = Math.max(skip, take);
    }
}
