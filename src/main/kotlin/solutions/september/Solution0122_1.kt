package com.sobiroglu.solutions.september

/**
 * memoization
 */
class Solution0122_1 {
    fun maxProfit(prices: IntArray): Int {
        val memo = Array<Int?>(prices.size + 1) { null }
        return findMaxProfit(0, prices, memo)
    }

    private fun findMaxProfit(curr: Int, prices: IntArray, memo: Array<Int?>): Int {
        if (curr > prices.size - 1) return 0
        if (memo[curr] != null) return memo[curr]!!
        var maxProfit = 0
        val skip = memo[curr + 1] ?: findMaxProfit(curr + 1, prices, memo)
        for (i in curr + 1 until prices.size) {
            val xDayProfit = prices[i] - prices[curr] + findMaxProfit(i + 1, prices, memo)
            maxProfit = maxOf(maxProfit, xDayProfit)
        }
        memo[curr] = maxOf(skip, maxProfit)
        return memo[curr]!!
    }
}