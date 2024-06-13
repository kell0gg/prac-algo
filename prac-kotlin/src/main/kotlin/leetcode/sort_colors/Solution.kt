package leetcode.sort_colors

// https://leetcode.com/problems/sort-colors/
class Solution {
    private val WHITE = 1
    fun sortColors(nums: IntArray) {
        var redPointer = 0
        var whitePointer = 0
        var bluePointer = nums.size
        while (whitePointer < bluePointer) {
            if (nums[whitePointer] < WHITE) {
                val temp = nums[redPointer]
                nums[redPointer] = nums[whitePointer]
                nums[whitePointer] = temp
                redPointer++
                whitePointer++
            } else if (nums[whitePointer] > WHITE) {
                bluePointer--
                val temp = nums[whitePointer]
                nums[whitePointer] = nums[bluePointer]
                nums[bluePointer] = temp
            } else {
                whitePointer++
            }
        }
    }
}
