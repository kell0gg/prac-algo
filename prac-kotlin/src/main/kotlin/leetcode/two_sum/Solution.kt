package leetcode.two_sum

// https://leetcode.com/problems/two-sum/description/
fun main() {
    val solution = Solution()
    val result = solution.twoSum(intArrayOf(1, 2, 9), 10)
    result.forEach {
        println(it)
    }
}

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map: MutableMap<Int, Int> = mutableMapOf()
        for (i in 0 until nums.size) {
            map.put(nums[i], i)
        }

        for (i in 0 until nums.size) {
            if (map.containsKey(target - nums[i]) && i != map[target - nums[i]]) {
                return intArrayOf(map[target - nums[i]] ?: 0, i)
            }
        }
        return intArrayOf(0, 0)
    }
}