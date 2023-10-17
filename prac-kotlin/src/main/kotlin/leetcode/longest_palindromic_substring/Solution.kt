package leetcode.longest_palindromic_substring

// https://leetcode.com/problems/longest-palindromic-substring/
fun main() {
    val solution = Solution()
    val result = solution.longestPalindrome("abba")
    println(result)
}

class Solution {
    var MAX = 0
    var LEFT = 0
    fun longestPalindrome(s: String): String {
        if (s.length == 1) return s

        for (i in 0 until s.length) {
            extendPalindrome(s, i, i + 1)
            extendPalindrome(s, i, i + 2)
        }

        return s.substring(LEFT, LEFT + MAX)
    }

    private fun extendPalindrome(s: String, left: Int, right: Int) {
        var l = left
        var r = right

        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--;
            r++;
        }
        val max = r - l - 1
        if (MAX < max) {
            LEFT = l + 1
            MAX = max
        }
    }
}