package leetcode.kth_largest_element_in_an_array

import java.util.*

// // https://leetcode.com/problems/kth-largest-element-in-an-array/
class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        // Arrays.sort(nums);
        // return nums[nums.length - k];
        val pq = PriorityQueue { a: Int, b: Int -> b - a }
        for (num in nums) {
            pq.add(num)
        }

        for (i in 1 until k) {
            pq.poll()
        }
        return pq.peek()
    }
}