package leetcode.best_time_to_buy_and_sell_stock

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
fun main(){
    val solution = Solution()
    val result = solution.maxProfit(intArrayOf(8,1,5,3,6,4))
    println(result)
}

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = prices[0]
        var maxProfit = 0
        for (price in prices) {
            minPrice = Math.min(minPrice, price)
            maxProfit = Math.max(maxProfit, price - minPrice)
        }
        return maxProfit
    }
}