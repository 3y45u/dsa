package arrays.trie;

import java.util.*;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        int[] arr1 = {1, 10, 100};
        int[] arr2 = {1000};

        int res = longestCommonPrefix(arr1, arr2);

        System.out.println(res  );

    }

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {

        int res = 0;

        Set<Integer> set = new HashSet<>();

        for (int n : arr1) {
            while (!set.contains(n) && n > 0) {
                set.add(n);
                n = n / 10;
            }
        }

        for (int n : arr2) {
            while (!set.contains(n) && n > 0) {
                n = n / 10;
            }

            if (n > 0) {
                res = Math.max(res, (int) Math.log10(n) + 1);
            }
        }
        return res;
    }

}
