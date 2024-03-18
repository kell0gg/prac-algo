package leetcode.binary_search_tree_to_greater_sum_tree

// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
class Solution {
    private var CURRENT_CUMULATIVE_SUM = 0

    fun bstToGst(root: TreeNode?): TreeNode? {
        return postOrderSearch(root)
    }

    private fun postOrderSearch(node: TreeNode?): TreeNode? {
        if (node == null) return null
        postOrderSearch(node.right)
        CURRENT_CUMULATIVE_SUM += node.`val`
        node.`val` = CURRENT_CUMULATIVE_SUM
        postOrderSearch(node.left)
        return node
    }
}