package leetcode.maximum_subarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/maximum-subarray/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // int result = solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -6, 4});
        int result = solution.maxSubArray(new int[]{-1});
        System.out.println(result);
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int current = 0;
        int max = Integer.MIN_VALUE + 10000;
        for (int i = 0; i < nums.length; i++) {
            current = Math.max(current + nums[i], nums[i]);
            max = Math.max(current, max);
        }
        return max;
    }
}
