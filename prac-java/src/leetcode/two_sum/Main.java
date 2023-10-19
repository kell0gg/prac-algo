package leetcode.two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.twoSum(new int[]{1, 2, 9}, 10);
        System.out.println(result[0] + "," + result[1]);
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return null;
    }
}