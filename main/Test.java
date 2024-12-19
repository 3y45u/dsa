package main;

public class Test {

    public static void main(String[] args) {
        String space = "abbcdbba";

        System.out.println(shortestPalindrome(space));

    }

    public static String shortestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }

        if (isPalindrome(s)) {
            return s;
        }

        int i = s.length() - 1;

        while (i > 0) {
            String subStr = s.substring(0, i + 1);
            if (isPalindrome(subStr)) {
                break;
            }
            i--;
        }

        String suffix = s.substring(i + 1);

        StringBuilder sb = new StringBuilder(suffix).reverse();

        sb.append(s);

        return sb.toString();
    }

    public static boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
