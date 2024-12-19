package dp;

import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {

        System.out.println(fib(89));

    }

    public static int fib(int n) {

        if (n <= 1) {
            return n;
        }

        // memoization
        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return solve(n, dp);

    }

    public static int solve(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
    }

    // using bottom up- this reduces the TC to o(n)
    public static int fib2(int n) {

        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        // dp[i] represents ith fib number
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }

    // using bottom up - reducting SC to O(1)
    // since we need state of only last two values
    public static int fib3(int n) {

        if (n <= 1) {
            return n;
        }

        int a = 0, b = 1, c = -1;

        for (int i = 1; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;

    }
}
