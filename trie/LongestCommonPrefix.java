package trie;

class TrieNode {

    TrieNode[] children = new TrieNode[10];  // 0, 1, 2...9
}

public class LongestCommonPrefix {

    public static TrieNode getTrieNode() {
        return new TrieNode();
    }

    public static void insert(int num, TrieNode root) {
        TrieNode crawl = root;
        String numStr = Integer.toString(num);

        for (char ch : numStr.toCharArray()) {
            int idx = ch - '0';
            if (crawl.children[idx] == null) {
                crawl.children[idx] = getTrieNode();
            }
            crawl = crawl.children[idx];
        }
    }

    // Returns the length of the longest prefix
    public static int search(int num, TrieNode root) {
        TrieNode crawl = root;
        String numStr = Integer.toString(num);
        int length = 0;

        for (char ch : numStr.toCharArray()) {
            int idx = ch - '0';
            if (crawl.children[idx] != null) {
                length++;
                crawl = crawl.children[idx];
            } else {
                break;
            }
        }

        return length;
    }

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {

        int res = 0;

        TrieNode root = getTrieNode();// new trie

        for (int n : arr1) {
            insert(n, root);
        }

        for (int n : arr2) {
            res = Math.max(res, search(n, root));
        }

        return res;

    }

    public static void main(String[] args) {

        int[] arr1 = {1, 10, 100};
        int[] arr2 = {1000};

        int res = longestCommonPrefix(arr1, arr2);

        System.out.println(res);
    }
}
