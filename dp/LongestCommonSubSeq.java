package dp;

import java.util.Arrays;

public class LongestCommonSubSeq {

    static int m;
    static int n;

    static int dp[][];

    public static void main(String[] args) {

    }

    public static int longestCommonSubsequence(String text1, String text2) {

        m = text1.length();
        n = text2.length();

        dp = new int[1001][1001];

        for (int ar[] : dp) {
            Arrays.fill(ar, -1);
        }

        return solve(text1, text2, 0, 0);

    }

    // using recursion + memoise
    public static int solve(String t1, String t2, int i, int j) {

        if (i >= m || j >= n) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (t1.charAt(i) == t2.charAt(j)) {
            return dp[i][j] = 1 + solve(t1, t2, i + 1, j + 1);
        }

        return dp[i][j] = Math.max(solve(t1, t2, i + 1, j), solve(t1, t2, i, j + 1));
    }

    //using bottom up
    public static int longestCommonSubsequence2(String text1, String text2) {

        m = text1.length();
        n = text2.length();

        dp = new int[m + 1][n + 1];

        for (int row = 0; row < m + 1; row++) {
            dp[row][0] = 0;
        }

        for (int col = 0; col < n + 1; col++) {
            dp[0][col] = 0;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];

    }
}
