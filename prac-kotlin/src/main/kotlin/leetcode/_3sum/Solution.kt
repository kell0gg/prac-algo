package leetcode._3sum

// https://leetcode.com/problems/3sum/
fun main() {
    val solution = Solution()
    val result = solution.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
    println(result)
}

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        var left = 0
        var right = 0
        var sum = 0
        nums.sort()

        val result: MutableSet<List<Int>> = mutableSetOf()
        for (i in 0 until nums.size - 2) {
            left = i + 1
            right = nums.size - 1

            while (left < right) {
                sum = nums[i] + nums[left] + nums[right]
                if (sum < 0) {
                    left++
                } else if (sum > 0) {
                    right--
                } else {
                    result.add(listOf(nums[i], nums[left], nums[right]))
                    left++
                    right--
                }
            }
        }
        return result.toList()
    }
}