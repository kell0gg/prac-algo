package leetcode.diameter_of_binary_tree

// // https://leetcode.com/problems/diameter-of-binary-tree/
fun main() {
    val root = TreeNode(2)
    root.left = TreeNode(3)
    root.right = null
    root.left!!.left = TreeNode(1)
    val solution = Solution()
    val result = solution.diameterOfBinaryTree(root)
    println(result)
}

class Solution {
    private var max = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)
        return max
    }

    private fun dfs(node: TreeNode?): Int {
        if (node == null) return 0
        val leftDepth = dfs(node.left)
        val rightDepth = dfs(node.right)
        max = Math.max(leftDepth + rightDepth, max)
        return Math.max(leftDepth, rightDepth) + 1
    }
}