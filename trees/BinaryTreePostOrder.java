package trees;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    // Default constructor
    TreeNode() {
    }

    // Constructor with value
    TreeNode(int val) {
        this.val = val;
    }

    // Constructor with value, left child, and right child
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // Method for post-order traversal
    void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        // Recur on the left subtree
        postOrderTraversal(node.left);

        // Recur on the right subtree
        postOrderTraversal(node.right);

        // Visit the node (process the node's value)
        System.out.print(node.val + " ");
    }

    
}
