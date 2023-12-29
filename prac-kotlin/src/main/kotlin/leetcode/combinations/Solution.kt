package leetcode.combinations

import java.util.*
import java.util.ArrayDeque
import java.util.Deque


// https://leetcode.com/problems/combinations/
fun main() {
    val solution = Solution()
    val result = solution.combine(5, 3)
    result.forEach { println(it) }
}

class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val result: MutableList<List<Int>> = ArrayList()
        val elements: Deque<Int> = ArrayDeque()
        dfs(elements, n, 1, k, result)
        return result
    }

    private fun dfs(elements: Deque<Int>, count: Int, start: Int, remainingCount: Int, result: MutableList<List<Int>>) {
        if (remainingCount == 0) {
            result.add(elements.toList())
            return
        }

        for (i in start until count + 1) {
            elements.addLast(i)
            dfs(elements, count, i + 1, remainingCount - 1, result)
            elements.pollLast()
        }
    }
}