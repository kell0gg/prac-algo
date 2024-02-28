package leetcode.invert_binary_tree;

// https://leetcode.com/problems/invert-binary-tree/description/
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        Solution solution = new Solution();
        solution.invertTree(root);
    }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        dfs(node.right);
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
}