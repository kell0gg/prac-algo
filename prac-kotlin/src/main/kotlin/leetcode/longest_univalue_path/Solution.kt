package leetcode.longest_univalue_path

import kotlin.math.max

// https://leetcode.com/problems/longest-univalue-path/
fun main(args: Array<String>) {
    // [5,4,5,1,1,null,5]
    val root = TreeNode(1)
    root.left = TreeNode(4)
    root.right = TreeNode(5)
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(4)
    root.right!!.left = null
    root.right!!.right = TreeNode(5)

//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(5);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(1);
//        root.right.left = null;
//        root.right.right = new TreeNode(5);
    val solution = Solution()
    val result = solution.longestUnivaluePath(root)
    println(result)
}

class Solution {
    private var max = 0

    fun longestUnivaluePath(root: TreeNode?): Int {
        dfs(root)
        return max
    }

    private fun dfs(node: TreeNode?): Int {
        if (node == null) return 0

        var left = dfs(node.left)
        var right = dfs(node.right)

        if (node.left != null && node.left!!.`val` == node.`val`) {
            left++
        } else {
            left = 0
        }

        if (node.right != null && node.right!!.`val` == node.`val`) {
            right++
        } else {
            right = 0
        }

        // sub tree 에서 최대가 될 수 있어서 max 를 구해야함
        max = max(max, (left + right))

        // 한쪽으로만 갈 수 있으니 두 방향 중 하나의 최대치만 선택함
        return max(left, right)
    }
}