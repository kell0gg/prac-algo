package leetcode.array_partition

// https://leetcode.com/problems/array-partition/
fun main() {
    val solution = Solution()
    val result = solution.arrayPairSum(intArrayOf(1, 4, 3, 2))
    println(result)
}

class Solution {
    fun arrayPairSum(nums: IntArray): Int {
        var sum = 0
        nums.sort()
        for (i in 0 until nums.size step 2) {
            sum += nums[i]
        }
        return sum
    }
}