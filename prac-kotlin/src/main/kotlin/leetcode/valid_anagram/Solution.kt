package leetcode.valid_anagram

// https://leetcode.com/problems/valid-anagram/
class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val s1 = s.toCharArray().sortedArray()
        val t1 = t.toCharArray().sortedArray()
        for (i in 0 until s.length) {
            if (s1[i] != t1[i]) return false
        }
        return true
    }
}