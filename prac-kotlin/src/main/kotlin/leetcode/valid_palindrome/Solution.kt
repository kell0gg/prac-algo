package leetcode.valid_palindrome

// https://leetcode.com/problems/valid-palindrome/
fun main() {
    val solution = Solution()
    val result = solution.isPalindrome("POP")
    println(result)
}

class Solution {
    private fun convertValidString(s: String): String {
        val stringBuilder = StringBuilder()
        for (c in s) {
            if (c.isLetterOrDigit()) {
                stringBuilder.append(c.toLowerCase())
            }
        }
        return stringBuilder.toString()
    }

    fun isPalindrome(s: String): Boolean {
        val convertedString = convertValidString(s)
        var start = 0
        var end = convertedString.length - 1
        while (start <= end) {
            if (convertedString[start] != convertedString[end]) return false
            start++
            end--
        }
        return true
    }
}