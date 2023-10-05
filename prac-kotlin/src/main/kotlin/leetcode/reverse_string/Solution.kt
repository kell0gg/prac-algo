package leetcode.reverse_string

// https://leetcode.com/problems/reverse-string/

fun main() {
    val solution = Solution()
    val s: CharArray = charArrayOf('a','b','c')
    solution.reverseString(s)
    println(s)
}

class Solution {
    fun reverseString(s: CharArray): Unit {
        var start = 0
        var end = s.size - 1;

        while (start < end) {
            val tmp = s[start]
            s[start] = s[end]
            s[end] = tmp
            start++
            end--
        }
    }
}