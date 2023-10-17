package leetcode.group_anagrams

// https://leetcode.com/problems/group-anagrams/
fun main() {
    val solution = Solution()
    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    val result = solution.groupAnagrams(strs)
    println(result)
}

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map: MutableMap<String, MutableList<String>> = HashMap()

        for (str: String in strs) {
            val key = str.toCharArray().apply { sort() }.joinToString("")
            map.computeIfAbsent(key) { mutableListOf() }.add(str)
        }
        return ArrayList<List<String>>(map.values)
    }
}