package leetcode.maximum_depth_of_binary_tree

import java.util.Deque
import java.util.ArrayDeque

// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
fun main(args: Array<String>) {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right!!.left = TreeNode(15)
    root.right!!.right = TreeNode(7)
    val solution = Solution()
    val result = solution.maxDepth(root)
    println(result)
}

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        var depth = 0
        val deque: Deque<TreeNode?> = ArrayDeque()
        deque.addLast(root)
        while (!deque.isEmpty()) {
            depth++
            val size = deque.size
            for (i in 0 until size) {
                val current = deque.pollFirst()!!
                if (current.left != null) {
                    deque.addLast(current.left)
                }
                if (current.right != null) {
                    deque.addLast(current.right)
                }
            }
        }
        return depth
    }
}