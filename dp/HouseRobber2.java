package dp;

import java.util.Arrays;

public class HouseRobber2 {

    int[] dp;

    public int solve(int[] nums, int i, int n) {
        if (i >= n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int skip = nums[i] + solve(nums, i + 2, n);
        int steal = solve(nums, i, n);

        return dp[i] = Math.max(skip, steal);

    }

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        dp = new int[101];

        Arrays.fill(dp, -1);

        // case 1 : take first house
        int firstHouse = solve(nums, 0, n - 2);

        Arrays.fill(dp, -1);

        // case 2 : when taking second house
        int secondHouse = solve(nums, 1, n - 1);

        return Math.max(firstHouse, secondHouse);

    }
}
