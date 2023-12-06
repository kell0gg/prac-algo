package leetcode.remove_duplicate_letters

import kotlin.collections.ArrayDeque
import kotlin.collections.HashMap

// https://leetcode.com/problems/valid-parentheses/description/
fun main(){
    val solution = Solution()
    val result = solution.removeDuplicateLetters("bcabc")
    println(result)
}

class Solution {
    fun removeDuplicateLetters(s: String): String {
        val countMap: MutableMap<Char, Int> = HashMap()
        val usedFlagMap: MutableMap<Char, Boolean> = HashMap()
        val deque: ArrayDeque<Char> = ArrayDeque()

        for (c in s) {
            countMap[c] = countMap.getOrDefault(c, 0) + 1
        }

        for (c in s) {
            countMap[c] = countMap[c]!! - 1

            if (usedFlagMap[c] == true) continue
            while (!deque.isEmpty() && deque.last() > c && countMap[deque.last()]!! > 0) usedFlagMap[deque.removeLast()] = false

            deque.addLast(c)

            usedFlagMap[c] = true
        }

        val stringBuilder = StringBuilder()
        while (!deque.isEmpty()) {
            stringBuilder.append(deque.removeFirst())
        }
        return stringBuilder.toString()
    }
}