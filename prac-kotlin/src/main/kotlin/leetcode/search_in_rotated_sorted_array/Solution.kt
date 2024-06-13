package leetcode.search_in_rotated_sorted_array

// https://leetcode.com/problems/search-in-rotated-sorted-array/
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[mid] > nums[right]) {
                left = mid + 1
            } else right = mid
        }

        val pivot = left

        left = 0
        right = nums.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2
            val midPivot = (mid + pivot) % nums.size
            if (nums[midPivot] < target) {
                left = mid + 1
            } else if (nums[midPivot] > target) {
                right = mid - 1
            } else {
                return midPivot
            }
        }
        return -1
    }
}