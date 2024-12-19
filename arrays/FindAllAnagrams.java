package arrays;
// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {

    public static void main(String[] args) {

    }

    public static List<Integer> findAnagrams(String s, String p) {

        int size = s.length();

        int[] counter = new int[26];

        for (int i = 0; i < p.length(); i++) {
            counter[p.charAt(i) - 'a']++;
        }

        int i = 0, j = 0;

        int k = p.length();

        List<Integer> res = new ArrayList<>();

        while (j < size) {
            counter[s.charAt(j) - 'a']--;

            if (j - i + 1 == k) {
                if (checkAllZero(counter)) {
                    res.add(i);
                }

                counter[s.charAt(i) - 'a']++;
                i++;
            }
            j++;
        }

        return res;
    }

    public static boolean checkAllZero(int[] counter) {
        for (int i : counter) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
