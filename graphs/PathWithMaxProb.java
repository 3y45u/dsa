package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PathWithMaxProb {

    public static void main(String[] args) {

        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5, 0.5, 0.2};

        double prob = maxProbability(3, edges, succProb, 0, 2);

        System.out.println(prob);

    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double pathProb = succProb[i];

            adj.get(u).add(new Pair(pathProb, v));
            adj.get(v).add(new Pair(pathProb, u));
        }

        double[] maxProb = new double[n];

        maxProb[start_node] = 1.0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> -Double.compare(a.getProb(), b.getProb()));

        pq.add(new Pair(1.0, start_node));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            double curProb = cur.getProb();
            int curNode = cur.getNode();

            if (curNode == end_node) {
                return curProb;
            }

            for (Pair next : adj.get(curNode)) {
                int nextNode = next.getNode();
                double pathProb = next.getProb();

                if (curProb * pathProb > maxProb[nextNode]) {
                    maxProb[nextNode] = curProb * pathProb;
                    pq.add(new Pair(maxProb[nextNode], nextNode));
                }
            }
        }

        return 0.0;
    }

}

class Pair {

    double prob;
    int node;

    public Pair() {
    }

    public Pair(double prob, int node) {
        this.prob = prob;
        this.node = node;
    }

    public double getProb() {
        return prob;
    }

    public int getNode() {
        return node;
    }

}
