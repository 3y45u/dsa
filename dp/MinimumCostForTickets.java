package dp;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-cost-for-tickets/
public class MinimumCostForTickets {

    int[] dp;
    int n;

    public int mincostTickets(int[] days, int[] costs) {
        n = days.length;
        dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return solve(0, days, costs);
    }

    public int solve(int i, int[] days, int[] costs) {
        if (i >= n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int one_day = costs[0] + solve(i + 1, days, costs);

        int max_days = days[i] + 6;

        int j = i;

        while (j < n && days[j] <= max_days) {
            j++;
        }

        int seven_day = costs[1] + solve(j, days, costs);

        max_days = days[i] + 29;

        j = i;

        while (j < n && days[j] <= max_days) {
            j++;
        }

        int thirty_day = costs[2] + solve(j, days, costs);

        return dp[i] = Math.min(one_day, Math.min(seven_day, thirty_day));
    }

}
