package heap;

// https://leetcode.com/problems/maximum-average-pass-ratio/?envType=daily-question&envId=2024-12-15
import java.util.PriorityQueue;

class MaximumPassRatio {

    public double maxAverageRatio(int[][] classes, int extraStudents) {

        int n = classes.length;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> Double.compare(a.pr, b.pr));

        for (int i = 0; i < n; i++) {
            double pr = (double) classes[i][0] / classes[i][1];
            minHeap.offer(new Pair(i, pr));
        }

        for (int i = 1; i <= extraStudents; i++) {
            if (!minHeap.isEmpty()) {
                Pair cur = minHeap.poll();
                int index = cur.index;

                double newPr = (double) (classes[index][0] + 1) / (classes[index][1] + 1);
                minHeap.offer(new Pair(index, newPr));
            }
        }

        double totalpr = 0.0;

        while (!minHeap.isEmpty()) {
            Pair cur = minHeap.poll();
            totalpr += cur.pr;
        }

        return totalpr / n;

    }

    public static void main(String[] args) {
        MaximumPassRatio obj = new MaximumPassRatio();
        int[][] pr = {{1, 2}, {3, 5}, {2, 2}};
        double ans = obj.maxAverageRatio(pr, 2);
        System.out.println(ans);
    }

    public class Pair {

        int index;
        double pr;

        Pair(int index, double pr) {
            this.index = index;
            this.pr = pr;
        }
    }
}
