package heap;
// https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC2406 {

    public static int minGroups(int[][] intervals) {

        // sort intervals based on starting time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // ek min heap lelo, jo ki store karega end points of groups
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // process karenge sare intervals ko ek ek karke
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (!heap.isEmpty() && start > heap.peek()) {
                heap.poll();
            }
            heap.offer(end);
        }

        // humare heap ka size hi number of groups ban jayenge
        return heap.size();
    }

}
