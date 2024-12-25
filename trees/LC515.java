package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC515 {

    public List<Integer> largestValues(TreeNode root) {

        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode cur = que.poll();

                max = Math.max(max, cur.val);

                if (cur.left != null) {
                    que.offer(cur.left);
                }

                if (cur.right != null) {
                    que.offer(cur.right);
                }
            }

            res.add(max);
        }
        return res;
    }
}
