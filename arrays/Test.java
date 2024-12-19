package arrays;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        String res = minWindow("ADOBECODEBANC", "ABC");

        System.out.println(res);
    }

    public static String minWindow(String s, String t) {

        int n = s.length();

        if (t.length() > n) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int reqCount = t.length();

        int i = 0, j = 0;

        int minWindowSize = Integer.MAX_VALUE;

        int start_i = i;

        while (j < n) {
            char charAt_j = s.charAt(j);

            if (map.containsKey(charAt_j) && map.get(charAt_j) > 0) {
                reqCount--;
            }
            map.put(charAt_j, map.getOrDefault(charAt_j, 0) - 1);

            while (reqCount == 0) {
                //shrink window
                int curWinSize = j - i + 1;

                if (minWindowSize > curWinSize) {
                    minWindowSize = curWinSize;
                    start_i = i;
                }

                char charAt_i = s.charAt(i);

                map.put(charAt_i, map.getOrDefault(charAt_i, 0) + 1);

                if (map.containsKey(charAt_i) && map.get(charAt_i) > 0) {
                    reqCount++;
                }
                i++;
            }

            j++;

        }

        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i + minWindowSize);

    }
}
