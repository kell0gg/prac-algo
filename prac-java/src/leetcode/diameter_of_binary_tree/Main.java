package leetcode.diameter_of_binary_tree;


// https://leetcode.com/problems/diameter-of-binary-tree/
public class Main {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = null;
        root.left.left = new TreeNode(1);
        Solution solution = new Solution();
        int result = solution.diameterOfBinaryTree(root);
        System.out.println(result);
    }
}

class Solution {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = dfs(node.left);
        int rightDepth = dfs(node.right);

        max = Math.max(max, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }
    /*
     * 1. 이 방법은 아래처럼 서브트리로 시작하는 게 더 긴 지름을 갖게 되면, (루트를 포함하지 않으면) 정답이 될 수 없었음
     *
     *       1
     *      / \
     *     2   3
     *    / \
     *   4   5
     *      / \
     *     6   7
     *        / \
     *       8   9
     */

    /*
    public int diameterOfBinaryTree(TreeNode root) {
        int leftMax = 0;
        int rightMax = 0;
        if (root.left != null) {
            leftMax = dfs(root.left, 1);
        }
        if (root.right != null) {
            rightMax = dfs(root.right, 1);
        }
        return leftMax + rightMax;
    }

    private int dfs(TreeNode current, int count) {
        if (current.left == null && current.right == null) {
            return count;
        }

        int leftMax = 0;
        int rightMax = 0;
        if (current.left != null) {
            leftMax = dfs(current.left, count + 1);
        }

        if (current.right != null) {
            rightMax = dfs(current.right, count + 1);
        }

        return Math.max(leftMax, rightMax);
    }
     */
}
