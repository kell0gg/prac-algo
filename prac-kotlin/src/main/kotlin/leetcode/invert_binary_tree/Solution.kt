package leetcode.invert_binary_tree

// https://leetcode.com/problems/invert-binary-tree/description/
class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        if (root.left != null) {
            dfs(root.left)
        }
        if (root.right != null) {
            dfs(root.right)
        }
        val tmp = root.left
        root.left = root.right
        root.right = tmp
        return root
    }

    private fun dfs(node: TreeNode?) {
        if (node == null) return
        dfs(node.left)
        dfs(node.right)
        val tmp = node.left
        node.left = node.right
        node.right = tmp
    }
}