package leetcode.convert_sorted_array_to_binary_search_tree;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }


    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(nums, left, mid - 1);
        node.right = dfs(nums, mid + 1, right);
        return node;
    }
}