package leetcode.climbing_stairs;

// https://leetcode.com/problems/climbing-stairs/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.climbStairs(2);
        System.out.println(result);
    }
}


class Solution {
    private final int[] dp = new int[46];

    {
        dp[0] = 1;
        dp[1] = 1;
    }

    public int climbStairs(int n) {
        if (n < 2) return dp[n];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
