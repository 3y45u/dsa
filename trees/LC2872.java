package trees;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/maximum-number-of-k-divisible-components/?envType=daily-question&envId=2024-12-21
public class LC2872 {

    int count = 0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];

        dfs(0, adj, vis, values, k);

        return count;
    }

    public int dfs(int u, List<List<Integer>> adj, boolean[] vis, int[] values, int k) {

        vis[u] = true;

        int sum = values[u];

        for (int v : adj.get(u)) {
            if (!vis[v]) {
                sum += dfs(v, adj, vis, values, k);
                sum %= k;
            }
        }

        if (sum % k == 0) {
            count++;
            return 0;
        }

        return sum;
    }

}
