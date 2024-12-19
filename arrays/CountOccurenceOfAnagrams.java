package arrays;
// https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
public class CountOccurenceOfAnagrams {

    public static void main(String[] args) {

        String txt = "aabaabaa";
        String pat = "aaba";

        int res = search(pat, txt);

        System.out.println(res);

    }

    public static int search(String pat, String txt) {

        int size = txt.length();

        int[] counter = new int[26];

        // sare character in patter ki freq count
        for (int i = 0; i < pat.length(); i++) {
            counter[pat.charAt(i) - 'a']++;
        }

        // ab ek window banayenge pat ke size ka
        int i = 0, j = 0;

        int k = pat.length();

        int result = 0;

        while (j < size) {
            // jab j pr ayenge to freq kam krni hai
            counter[txt.charAt(j) - 'a']--;

            if (j - i + 1 == k) {
                if (checkSareCharkiFreqZeroHai(counter)) {
                    result++;
                }

                counter[txt.charAt(i) - 'a']++;
                i++;
            }
            j++;
        }

        return result;
    }

    public static boolean checkSareCharkiFreqZeroHai(int[] counter) {
        for (int i : counter) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
