package leetcode.maximum_depth_of_binary_tree;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution solution = new Solution();
        int result = solution.maxDepth(root);
        System.out.println(result);
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            depth++;

            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = deque.pollFirst();
                if (current.left != null) {
                    deque.addLast(current.left);
                }
                if (current.right != null) {
                    deque.addLast(current.right);
                }
            }
        }
        return depth;
    }
}