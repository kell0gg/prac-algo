package leetcode.valid_parentheses

import java.util.ArrayDeque
import java.util.Deque

// https://leetcode.com/problems/valid-parentheses/description/
class Solution {
    fun isValid(s: String): Boolean {
        val deque: Deque<Char> = ArrayDeque()
        val mappingTable = mapOf(')' to '(', '}' to '{', ']' to '[')

        for (c in s) {
            if (!mappingTable.containsKey(c)) {
                deque.addLast(c)
            } else {
                if (deque.isEmpty() || deque.pollLast() != mappingTable[c]) return false
            }
        }
        return deque.isEmpty()
    }
}