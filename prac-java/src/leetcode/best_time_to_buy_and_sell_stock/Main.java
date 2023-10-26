package leetcode.best_time_to_buy_and_sell_stock;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.maxProfit(new int[]{8, 1, 5, 3, 6, 4});
        System.out.println(result);
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        // 현재까지 저점을 구함
        // 이후 고점이 나오면 매도했을 때 얼마인지 계산함
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
