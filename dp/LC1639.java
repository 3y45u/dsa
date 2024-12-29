package dp;

import java.util.Arrays;

// https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/description/
public class LC1639 {

    int m;
    int k;
    int[][] dp;
    int mod = 1_000_000_007;

    public int numWays(String[] words, String target) {
        m = target.length();
        k = words[0].length();
        dp = new int[m + 1][k + 1];

        for (int[] ar : dp) {
            Arrays.fill(ar, -1);
        }

        int[][] freq = new int[26][k];
        for (int col = 0; col < k; col++) {
            for (String word : words) {
                char ch = word.charAt(col);
                freq[ch - 'a'][col]++;
            }
        }

        return solve(0, 0, freq, target);
    }

    public int solve(int i, int j, int[][] freq, String target) {
        if (i == m) {
            return 1;
        }

        if (j == k) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int skip = solve(i, j + 1, freq, target) % mod;
        int take = 0;
        if (freq[target.charAt(i) - 'a'][j] > 0) {
            take = (int) ((1L * freq[target.charAt(i) - 'a'][j] * solve(i + 1, j + 1, freq, target)) % mod);
        }

        return dp[i][j] = (skip + take) % mod;
    }
}
