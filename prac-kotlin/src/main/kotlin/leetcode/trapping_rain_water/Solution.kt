package leetcode.trapping_rain_water

// https://leetcode.com/problems/trapping-rain-water/
fun main() {
    val solution = Solution()
    val result = solution.trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1))
    println(result)
}

class Solution {
    fun trap(height: IntArray): Int {
        var volume = 0;
        var left = 0;
        var right = height.size - 1
        var leftMax = height[left]
        var rightMax = height[right]

        while (left <= right) {
            leftMax = Math.max(leftMax, height[left])
            rightMax = Math.max(rightMax, height[right])

            if (leftMax < rightMax) {
                volume += (leftMax - height[left])
                left++
            } else {
                volume += (rightMax - height[right])
                right--
            }
        }
        return volume
    }
}