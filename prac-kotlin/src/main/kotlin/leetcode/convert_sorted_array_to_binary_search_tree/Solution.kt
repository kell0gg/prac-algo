package leetcode.convert_sorted_array_to_binary_search_tree

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
fun main(){
    val solution = Solution()
    solution.sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9))
}
class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return dfs(nums, 0, nums.size-1)
    }
    private fun dfs(nums: IntArray, left: Int, right: Int): TreeNode? {
        if (left > right) return null
        val mid = left + (right - left) / 2
        val node = TreeNode(nums[mid])
        node.left = dfs(nums, left, mid - 1)
        node.right = dfs(nums, mid + 1, right)
        return node
    }
}