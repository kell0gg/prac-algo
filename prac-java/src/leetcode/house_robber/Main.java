package leetcode.house_robber;

// https://leetcode.com/problems/house-robber/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.rob(new int[]{1, 2, 3, 1});
        System.out.println(result);
    }
}

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        int max = 0;
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
