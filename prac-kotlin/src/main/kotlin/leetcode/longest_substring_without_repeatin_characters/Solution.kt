package leetcode.longest_substring_without_repeatin_characters

fun main() {
    val solution = Solution()
    val result = solution.lengthOfLongestSubstring("abcabab")
    println(result)
}

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var left = 0
        var right = 0
        var max = 0
        val map: MutableMap<Char, Int> = mutableMapOf()

        for (c in s) {
            if (map.contains(c) && map[c]!! >= left) {
                left = map[c]!! + 1
            } else {
                max = Math.max(max, right - left + 1)
            }
            map[c] = right
            right++
        }

        return max
    }
}