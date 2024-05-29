package leetcode.largest_number

import java.math.BigInteger

// https://leetcode.com/problems/largest-number/description/
fun main(){
    val solution = Solution()
    val result = solution.largestNumber(intArrayOf(0,3))
    println(result)
}

class Solution {
    fun largestNumber(nums: IntArray): String {
        val stringNums: MutableList<String> = mutableListOf()
        val stringBuilder = StringBuilder()
        for (i in nums.indices) {
            stringNums.add(nums[i].toString())
        }

        stringNums.sortWith(
            Comparator { o1, o2 ->
                val sum1 = BigInteger(o2 + o1)
                val sum2 = BigInteger(o1 + o2)
                sum1.compareTo(sum2)
            }
        )

        stringNums.forEach { stringBuilder.append(it) }
        val result = stringBuilder.toString()
        return if (result[0] == '0') "0" else result
    }
}