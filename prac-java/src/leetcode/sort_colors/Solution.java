package leetcode.sort_colors;

// https://leetcode.com/problems/sort-colors/
class Solution {
    private final int WHITE = 1;

    public void sortColors(int[] nums) {

        int redPointer = 0;
        int whitePointer = 0;
        int bluePointer = nums.length;

        while (whitePointer < bluePointer) {

            if (nums[whitePointer] < WHITE) {
                int temp = nums[redPointer];
                nums[redPointer] = nums[whitePointer];
                nums[whitePointer] = temp;
                redPointer++;
                whitePointer++;

            } else if (nums[whitePointer] > WHITE) {
                bluePointer--;
                int temp = nums[whitePointer];
                nums[whitePointer] = nums[bluePointer];
                nums[bluePointer] = temp;

            } else {
                whitePointer++;
            }
        }
    }
}
