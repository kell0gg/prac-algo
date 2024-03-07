package leetcode.balanced_binary_tree;

// https://leetcode.com/problems/balanced-binary-tree/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        boolean result = solution.isBalanced(root);
        System.out.println(result);
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        int result = dfs(root);
        return result != -1;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;


        int leftDepth = dfs(node.left);
        int rightDepth = dfs(node.right);

        if (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) return -1;

        return Math.max(leftDepth, rightDepth) + 1;
    }
}