package leetcode.letter_combinations_of_a_phone_number

import java.util.HashMap

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
fun main() {
    val solution = Solution()
    val result = solution.letterCombinations("23")
    println(result)
}

class Solution {
    fun letterCombinations(digits: String): List<String> {
        val result: MutableList<String> = ArrayList()
        if (digits.isEmpty()) return result
        val mapOfDigits: MutableMap<Char, List<Char>> = HashMap()
        mapOfDigits['0'] = listOf()
        mapOfDigits['1'] = listOf()
        mapOfDigits['2'] = listOf('a', 'b', 'c')
        mapOfDigits['3'] = listOf('d', 'e', 'f')
        mapOfDigits['4'] = listOf('g', 'h', 'i')
        mapOfDigits['5'] = listOf('j', 'k', 'l')
        mapOfDigits['6'] = listOf('m', 'n', 'o')
        mapOfDigits['7'] = listOf('p', 'q', 'r', 's')
        mapOfDigits['8'] = listOf('t', 'u', 'v')
        mapOfDigits['9'] = listOf('w', 'x', 'y', 'z')
        dfs(digits, mapOfDigits, 0, "", result)
        return result
    }

    private fun dfs(
        digits: String,
        mapOfDigits: Map<Char, List<Char>>,
        index: Int,
        path: String,
        result: MutableList<String>
    ) {
        if (path.length == digits.length || index >= digits.length) {
            result.add(path)
            return
        }

        for (c in mapOfDigits[digits[index]]!!) {
            dfs(digits, mapOfDigits, index + 1, path + c, result)
        }
    }
}