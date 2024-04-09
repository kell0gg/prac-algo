package leetcode.minimum_distance_between_bst_nodes

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
// https://leetcode.com/problems/minimum-distance-between-bst-nodes/
fun main() {
    val root = TreeNode(5)
    root.left = TreeNode(3)
    root.left!!.left = TreeNode(1)
    root.left!!.right = TreeNode(4)
    root.right = TreeNode(7)
    root.right!!.right = TreeNode(9)
    root.right!!.left = TreeNode(6)
    val solution = Solution()
    val result = solution.minDiffInBST(root)
    println(result)
}

class Solution {
    private var minDiff = Int.MAX_VALUE
    private var prev = Int.MIN_VALUE + 10000
    fun minDiffInBST(root: TreeNode?): Int {
        dfs(root)
        return minDiff
    }

    private fun dfs(node: TreeNode?) {
        if (node == null) return
        dfs(node.left)
        // 이전 노드는 무조건 현재 노드보다 작음, node.`val` - prev 은 overflow 가 발생할 수 있어서 node 의 최댓값만큼 값을 더해서 초기값을 지정함
        minDiff = Math.min(minDiff, node.`val` - prev)
        prev = node.`val`
        dfs(node.right)
    }

    private fun dfsStack(root: TreeNode?){

    }
}