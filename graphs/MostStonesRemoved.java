package graphs;

public class MostStonesRemoved {

    public static void main(String[] args) {

    }

    public static void dfs(int index, boolean[] vis, int[][] stones) {
        vis[index] = true;

        for (int i = 0; i < stones.length; i++) {
            int row = stones[index][0];
            int col = stones[index][1];

            if (!vis[i] && (stones[i][0] == row || stones[i][1] == col)) {
                dfs(i, vis, stones);
            }
        }
    }

    public static int removeStones(int[][] stones) {
        int n = stones.length;
        int gang = 0;

        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, vis, stones);
                gang++;
            }
        }

        return n - gang;
    }
}
