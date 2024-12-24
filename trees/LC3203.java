package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees/
public class LC3203 {

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {

        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> adj1 = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj1.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj2.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int[] edge = edges1[i];
            int u = edge[0];
            int v = edge[1];

            adj1.get(u).add(v);
            adj1.get(v).add(u);
        }

        for (int i = 0; i < m - 1; i++) {
            int[] edge = edges2[i];
            int u = edge[0];
            int v = edge[1];

            adj2.get(u).add(v);
            adj2.get(v).add(u);
        }

        int d1 = findDiameter(n, adj1);
        int d2 = findDiameter(m, adj2);

        int merged = ((d1 + 1) / 2) + ((d2 + 1) / 2) + 1;

        int res = Math.max(Math.max(d1, d2), merged);

        return res;

    }

    public int findDiameter(int n, List<List<Integer>> adj) {
        int[] farthest = findFarthest(n, adj, 0);
        int[] res = findFarthest(n, adj, farthest[0]);

        return res[1];
    }

    public int[] findFarthest(int n, List<List<Integer>> adj, int source) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] vis = new boolean[n];

        int farthest = source;
        int maxDistance = 0;

        que.offer(source);
        vis[source] = true;

        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                int cur = que.poll();

                farthest = cur;

                for (int v : adj.get(cur)) {
                    if (!vis[v]) {
                        que.offer(v);
                        vis[v] = true;
                    }
                }
            }

            if (!que.isEmpty()) {
                maxDistance++;
            }
        }

        return new int[]{farthest, maxDistance};

    }

}
