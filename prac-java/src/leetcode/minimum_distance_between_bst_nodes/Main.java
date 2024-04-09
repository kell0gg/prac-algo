package leetcode.minimum_distance_between_bst_nodes;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(6);
        Solution solution = new Solution();
        int result = solution.minDiffInBST(root);
        System.out.println(result);
    }
}

class Solution {
    int prev = Integer.MIN_VALUE + 10000;
    int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
//        dfs(root);
//        return min;
        return dfsStack(root);
    }


    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        // 왼쪽 -> 중앙 -> 오른쪽 노드로 탐색하기 때문에 항상 현재 값이 이전 값보다 클 수 있음
        min = Math.min(node.val - prev, min);
        prev = node.val;
        dfs(node.right);
    }

    private int dfsStack(TreeNode root) {
        int prev = Integer.MIN_VALUE + 10000;
        int min = Integer.MAX_VALUE;
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;

        while (!deque.isEmpty() || node != null) {
            while (node != null) {
                deque.addLast(node);
                node = node.left;
            }

            node = deque.pollLast();
            min = Math.min(min, node.val - prev);
            prev = node.val;

            node = node.right;
        }

        return min;
    }
}
