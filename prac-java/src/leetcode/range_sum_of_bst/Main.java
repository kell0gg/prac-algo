package leetcode.range_sum_of_bst;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/range-sum-of-bst/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);
        int result = solution.rangeSumBST(root, 7, 15);
        System.out.println(result);
    }
}

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return bfs(root, low, high);
    }

    // brute force
    private int dfs0(TreeNode node, int low, int high) {
        if (node == null) return 0;

        int sum = 0;
        if (low <= node.val && node.val <= high) {
            sum += node.val;
        }
        sum += dfs0(node.left, low, high);
        sum += dfs0(node.right, low, high);
        return sum;
    }

    private int dfs1(TreeNode node, int low, int high) {
        if (node == null) return 0;

        // 현재 값이 구하고자 하는 값보다 크다면, 우측으로 탐색은 의미가 없음, 어차피 더 진행해도 큰 값만 존재함
        if (node.val > high) {
            return dfs1(node.left, low, high);
        }

        // 현재 값이 구하고자 하는 값보다 작다면, 좌측으로 탐색은 의미가 없음, 어차피 더 진행해도 작은 값만 존재함
        if (node.val < low) {
            return dfs1(node.right, low, high);
        }

        return node.val + dfs1(node.left, low, high) + dfs1(node.right, low, high);
    }

    private int dfs2(TreeNode node, int low, int high) {
        if (node == null) return 0;
        int sum = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(node);

        while (!deque.isEmpty()) {
            TreeNode current = deque.pollLast();

            if (current.val > low) {
                if (current.left != null) deque.addLast(current.left);
            }
            if (current.val < high) {
                if (current.right != null) deque.addLast(current.right);
            }

            if (current.val >= low && current.val <= high) {
                sum += current.val;
            }
        }

        return sum;
    }

    private int bfs(TreeNode node, int low, int high) {
        if (node == null) return 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(node);
        int sum = 0;
        while (!deque.isEmpty()) {
            TreeNode current = deque.pollFirst();

            if (current.val >= low && current.val <= high) {
                sum += current.val;
            }

            // 만약 현재 값이 찾고자 하는 값보다 작다면, 좌측으로는 더 이상 안가도 됨
            if (current.val < low) {
                if (current.right != null) deque.addLast(current.right);
            }

            // 만약 현재 값이 찾고자 하는 값보다 더 크다면, 우측으로는 더 이상 안가도 됨
            else if (current.val > high) {
                if (current.left != null) deque.addLast(current.left);
            }

            // 둘 다 아니면 그냥 둘 다 탐색해야함
            else {
                if (current.left != null) deque.addLast(current.left);
                if (current.right != null) deque.addLast(current.right);
            }
        }

        return sum;
    }
}
