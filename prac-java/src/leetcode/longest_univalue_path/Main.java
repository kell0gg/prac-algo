package leetcode.longest_univalue_path;

// https://leetcode.com/problems/longest-univalue-path/description/
public class Main {
    public static void main(String[] args) {
        // [5,4,5,1,1,null,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right.left = null;
        root.right.right = new TreeNode(5);

//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(5);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(1);
//        root.right.left = null;
//        root.right.right = new TreeNode(5);

        Solution solution = new Solution();
        int result = solution.longestUnivaluePath(root);
        System.out.println(result);
    }
}

class Solution {
    private int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (node.left != null && node.left.val == node.val) {
            left++;
        } else {
            left = 0;
        }

        if (node.right != null && node.right.val == node.val) {
            right++;
        } else {
            right = 0;
        }

        // sub tree 에서 최대가 될 수 있음
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }
}