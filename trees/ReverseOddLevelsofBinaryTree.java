package trees;

// https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/?envType=daily-question&envId=2024-12-20
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseOddLevelsofBinaryTree {

    public TreeNode reverseOddLevels(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        int level = 0;

        while (!q.isEmpty()) {
            int n = q.size();

            List<TreeNode> nodeLevels = new ArrayList<>();

            while (n-- > 0) {
                TreeNode cur = q.poll();

                nodeLevels.add(cur);

                if (cur.left != null) {
                    q.offer(cur.left);
                }

                if (cur.right != null) {
                    q.offer(cur.right);
                }

            }

            if (level % 2 != 0) {
                int l = 0;
                int r = nodeLevels.size() - 1;

                while (l < r) {
                    int temp = nodeLevels.get(l).val;
                    nodeLevels.get(l).val = nodeLevels.get(r).val;
                    nodeLevels.get(r).val = temp;
                    l++;
                    r--;
                }

            }

            level++;
        }

        return root;

    }
}
