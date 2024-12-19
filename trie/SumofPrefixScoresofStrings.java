package trie;
// https://leetcode.com/problems/sum-of-prefix-scores-of-strings/description/

public class SumofPrefixScoresofStrings {

    static class TrieNode {

        int count = 0;
        TrieNode[] child = new TrieNode[26];

        public TrieNode() {
            for (int i = 0; i < 26; i++) {
                child[i] = null;
            }

            count = 0;
        }

        public TrieNode getTrieNode() {
            return new TrieNode();
        }

        public void insert(String s, TrieNode root) {
            TrieNode travel = root;

            for (char c : s.toCharArray()) {
                int index = c - 'a';

                if (travel.child[index] == null) {
                    travel.child[index] = getTrieNode();
                }

                travel.child[index].count++;

                travel = travel.child[index];
            }
        }

        public int getScore(String s, TrieNode root) {
            int score = 0;

            TrieNode travel = root;

            for (char c : s.toCharArray()) {
                int index = c - 'a';

                if (travel.child[index] == null) {
                    return score;
                }

                score += travel.child[index].count;
                travel = travel.child[index];
            }

            return score;
        }

    }

    public static int[] sumPrefixScores(String[] words) {

        int[] res = new int[words.length];

        TrieNode root = new TrieNode();

        for (String s : words) {
            root.insert(s, root);
        }

        for (int i = 0; i < words.length; i++) {
            res[i] = root.getScore(words[i], root);
        }

        return res;

    }

    public static void main(String[] args) {

        String[] words = {"abcd"};

        int res[] = sumPrefixScores(words);

        for (int i : res) {
            System.out.println(i);
        }

    }

}
