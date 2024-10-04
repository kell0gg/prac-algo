package leetcode.fibonacci_number;

// https://leetcode.com/problems/fibonacci-number/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.fib(5);
        System.out.println(result);
    }
}

class Solution {
    private final int[] dp = new int[31];

    {
        dp[1] = 1;
        dp[2] = 1;
    }

    public int fib(int n) {
        // return fibWithMemoization(n);
        return fibWithTabulation(n);
    }

    private int fibWithMemoization(int n) {
        // f(0) = 0, f(1) = 1, f(2) = 1, f(3) = 2
        if (n < 2) return n;
        if (dp[n] != 0) return dp[n];

        dp[n] = fibWithMemoization(n - 1) + fibWithMemoization(n - 2);
        return dp[n];
    }

    private int fibWithTabulation(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}