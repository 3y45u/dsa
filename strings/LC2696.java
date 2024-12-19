package strings;

import java.util.Stack;

// https://leetcode.com/problems/minimum-string-length-after-removing-substrings/
public class LC2696 {

    public static int minLength(String s) {

        // same question hai balance parenthesis jaise
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            boolean pop = false;

            if (c == 'B' && !st.isEmpty() && st.peek() == 'A') {
                st.pop();
                pop = true;
            }

            if (c == 'D' && !st.isEmpty() && st.peek() == 'C') {
                st.pop();
                pop = true;
            }

            if(!pop){
                st.push(c);
            }

        }

        return st.size();

    }

    public static void main(String[] args) {
        String a = "ABFCACDB";

        System.out.println(minLength(a));
    }
}
