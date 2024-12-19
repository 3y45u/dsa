package stack;
// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/

import java.util.Stack;

public class MinSwaps {

    public static int minSwaps(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '[') {
                st.push(c);
            } else if (!st.isEmpty()) {
                st.pop();
            }
        }

        return st.size() + 1 / 2;

    }

    public static void main(String[] args) {

    }

}
