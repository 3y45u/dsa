package arrays;
// https://leetcode.com/problems/rank-transform-of-an-array/description/?envType=daily-question&envId=2024-10-02

import java.util.ArrayList;
import java.util.Collections;

public class RankTransformOfAnArray {

    public static int[] arrayRankTransform(int[] ar) {

        String s1 = "";
        s1.length();
        

        ArrayList<Integer> list = new ArrayList<>();

        for (int i : ar) {
            if (!list.contains(i)) {
                list.add(i);
            }
        }

        Collections.sort(list);

        for (int i = 0; i < ar.length; i++) {
            int val = ar[i];
            int rank = binarySearch(list, val) + 1;
            ar[i] = rank;
        }

        return ar;
    }

    public static int binarySearch(ArrayList<Integer> list, int val) {
        int n = list.size();

        int l = 0, r = n - 1;

        while (l <= r) {

            int mid = l + (r - l) / 2;
            if (list.get(mid) == val) {
                return mid;
            } else if (list.get(mid) < val) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        return -1;

    }

    public static void main(String[] args) {

        int[] ar = {40, 10, 20, 30};

        ar = arrayRankTransform(ar);

        for (int i : ar) {
            System.out.print(i + " ");
        }

    }

}
