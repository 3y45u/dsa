package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
public class LC632 {

    public static int[] smallestRange(List<List<Integer>> nums) {
        int[] res = new int[2];

        // Flatten all the lists into a single list
        List<Integer> ar = new ArrayList<>();
        for (List<Integer> li : nums) {
            for (int i : li) {
                ar.add(i);
            }
        }

        // Sort the flattened list
        Collections.sort(ar);

        int range = Integer.MAX_VALUE;

        if (ar.size() == 1) {
            res[0] = ar.get(0);
            res[1] = ar.get(0);
            return res;
        }

        // Iterate over all pairs of elements in the sorted list
        for (int i = 0; i < ar.size(); i++) {
            for (int j = i + 1; j < ar.size(); j++) {
                int curRange = ar.get(j) - ar.get(i);

                // Check if this range [ar.get(i), ar.get(j)] covers at least one element from each list
                if (curRange < range && coversAllLists(nums, ar.get(i), ar.get(j))) {
                    range = curRange;
                    res[0] = ar.get(i);
                    res[1] = ar.get(j);
                }
            }
        }

        return res;
    }

    // Helper function to check if the range [i, j] covers at least one element from each list
    private static boolean coversAllLists(List<List<Integer>> nums, int i, int j) {
        for (List<Integer> list : nums) {
            boolean found = false;
            // Check if the current list contains a number within the range [i, j]
            for (int num : list) {
                if (num >= i && num <= j) {
                    found = true;
                    break;
                }
            }
            // If one of the lists does not have a number in the range, return false
            if (!found) {
                return false;
            }
        }
        return true;  // All lists have at least one element in the range
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(List.of(4, 10, 15, 24, 26));
        nums.add(List.of(0, 9, 12, 20));
        nums.add(List.of(5, 18, 22, 30));

        int[] result = smallestRange(nums);
        System.out.println("Smallest range is: [" + result[0] + ", " + result[1] + "]");
    }
}
