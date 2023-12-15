package leetcode.jewels_and_stones

// https://leetcode.com/problems/jewels-and-stones/description/
class Solution {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        val set: MutableSet<Char> = HashSet()
        var count = 0
        for (c in jewels) set.add(c)
        for (c in stones) {
            if (set.contains(c)) count++
        }
        return count
    }
}