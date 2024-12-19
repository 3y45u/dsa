package recursion;

import java.util.*;

public class kThSmallestLexographical {

    public static void main(String[] args) {

        System.out.println(findKthNumber(4289384, 1922239));

    }

    public static int findKthNumber(int n, int k) {

        //PriorityQueue<String> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        //TLE exceed in both heap and list

        /*
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            solve(i, n, k, res);
        }

        

        return res.get(k-1);

         */
        // using counting prefixes
        int cur = 1;

        k = k - 1;

        while (k > 0) {
            int count = countPrefix(cur, n);

            if (count <= k) {
                k = k - count;
                cur++;
            } else {
                cur = cur * 10;
                k = k - 1;
            }
        }

        return cur;

    }

    public static int countPrefix(int prefix, int n) {

        long cur = prefix;
        long next = prefix + 1;

        int count = 0;

        while (cur <= n) {
            count += (long) Math.min(n + 1L, next) - cur;
            cur *= 10;
            next *= 10;
        }

        return count;

    }

    public static void solve(int cur, int n, int k, List<Integer> res) {

        if (cur > n) {
            return;
        }

        res.add(cur);

        for (int i = 0; i <= 9; i++) {
            int temp = (cur * 10) + i;

            if (temp > n) {
                return;
            }

            solve(temp, n, k, res);
        }

    }

}
