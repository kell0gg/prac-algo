package leetcode.subsets

import java.util.*
import java.util.ArrayDeque
import java.util.Deque

// https://leetcode.com/problems/subsets/
fun main() {
    val solution = Solution()
    val result = solution.subsets(intArrayOf(1, 2, 4))
    result.forEach { println(it) }
}

class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result: MutableList<List<Int>> = mutableListOf()
        dfs(nums, ArrayDeque(), 0, result)
        return result
    }

    private fun dfs(nums: IntArray, elements: Deque<Int>, start: Int, result: MutableList<List<Int>>) {
        result.add(ArrayList(elements))

        for (i in start until nums.size) {
            elements.addLast(nums[i])
            dfs(nums, elements, i + 1, result)
            elements.pollLast()
        }
    }
}