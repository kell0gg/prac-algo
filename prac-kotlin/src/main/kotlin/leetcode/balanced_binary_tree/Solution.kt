package leetcode.balanced_binary_tree

// https://leetcode.com/problems/balanced-binary-tree/description/
class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        return dfs(root) != -1
    }

    private fun dfs(node: TreeNode?): Int {
        if (node == null) return 0

        val leftDepth = dfs(node.left)
        val rightDepth = dfs(node.right)

        if (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) return -1

        return Math.max(leftDepth, rightDepth) + 1
    }
}