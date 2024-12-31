package dp;

import java.util.Arrays;

public class CountWaysToBuildGoodStrings {

    int L;
    int H;
    int Z;
    int O;

    int[] dp;

    int mod = 1_000_000_007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        L = low;
        H = high;
        Z = zero;
        O = one;

        dp = new int[high + 1];

        Arrays.fill(dp, -1);

        return solve(0);

    }

    public int solve(int length) {
        if (length > H) {
            return 0;
        }

        if (dp[length] != -1) {
            return dp[length];
        }

        int add_one = 0;

        if (length >= L) {
            add_one = 1;
        }

        int append_zero = solve(length + Z) % mod;
        int append_one = solve(length + O) % mod;

        return dp[length] = (add_one + append_zero + append_one) % mod;
    }
}
