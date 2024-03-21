package leetcode.range_sum_of_bst

// https://leetcode.com/problems/range-sum-of-bst/

fun main(args: Array<String>) {
    val solution = Solution()
    val root = TreeNode(10)
    root.left = TreeNode(5)
    root.left!!.left = TreeNode(3)
    root.left!!.right = TreeNode(7)
    root.right = TreeNode(15)
    root.right!!.right = TreeNode(18)
    val result = solution.rangeSumBST(root, 7, 15)
    println(result)
}

class Solution {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        return dfs(root, low, high)
    }

    private fun dfs(node: TreeNode?, low: Int, high: Int): Int {
        if (node == null) return 0

        if (node.`val` < low) {
            return dfs(node.right, low, high)
        }

        if (node.`val` > high) {
            return dfs(node.left, low, high)
        }

        return node.`val` + dfs(node.left, low, high) + dfs(node.right, low, high)
    }
}