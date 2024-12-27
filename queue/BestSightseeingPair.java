package queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class BestSightseeingPair {

    public int maxScoreSightseeingPair(int[] values) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int res = -1;

        for (int i = 0; i < values.length; i++) {
            if (!pq.isEmpty()) {
                res = Math.max(res, pq.peek() + values[i] - i);
            }
            pq.offer(values[i] + i);
        }

        return res;

    }

}
