package leetcode.product_of_array_except_self

// https://leetcode.com/problems/product-of-array-except-self/description/
fun main() {
    val solution = Solution()
    val result = solution.productExceptSelf(intArrayOf(1, 3, 5, 7))
    result.forEach {
        println(it)
    }
}

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        var p = 1
        for (i in nums.indices) {
            result[i] = p
            p *= nums[i]
        }

        p = 1
        for (i in nums.indices.reversed()) {
            result[i] *= p
            p *= nums[i]
        }
        return result
    }
}