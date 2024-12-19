package stack;

// https://leetcode.com/problems/max-chunks-to-make-sorted/description/
public class MaxChunksToMakeSorted {

    // TC : O(n)
    // SC : O(1)
    public int maxChunksToSorted(int[] arr) {

        int n = arr.length;

        int max = -1;
        int chunks = 0;

        for (int i = 0; i < n; i++) {

            max = Math.max(max, arr[i]);

            if (max == i) {
                chunks++;
            }
        }

        return chunks;

    }
}
