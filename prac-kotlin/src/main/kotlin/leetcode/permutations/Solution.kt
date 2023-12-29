package leetcode.permutations

import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

// https://leetcode.com/problems/permutations/description/
fun main() {
    val solution = Solution()
    val result = solution.permute(intArrayOf(1, 2, 3))
    result.forEach {
        println(it)
    }
}

class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val result: MutableList<List<Int>> = mutableListOf()
        val listNums = mutableListOf<Int>()
        nums.forEach { listNums.add(it) }
        // Arrays.stream(nums).boxed().collect(Collectors.toList())
        dfs(mutableListOf(), listNums, result)
        return result
    }

    private fun dfs(generatedElements: MutableList<Int>, remainingElements: List<Int>, result: MutableList<List<Int>>) {
        if (remainingElements.isEmpty()) {
            result.add(ArrayList(generatedElements))
            return
        }

        for (element in remainingElements) {
            val elementToPermute: MutableList<Int> = ArrayList(remainingElements)
            elementToPermute.remove(element)
            generatedElements.add(element)
            dfs(generatedElements, elementToPermute, result)
            generatedElements.remove(element)
        }
    }
}