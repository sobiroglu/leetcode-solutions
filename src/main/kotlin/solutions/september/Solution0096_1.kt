package com.sobiroglu.solutions.september

class Solution0096_1 {
    fun numTrees(n: Int): Int {
        if (n == 0) return 0
        val dp = Array(n) { IntArray(n) { -1 } }
        return bst(1, n, dp)
    }

    fun bst(start: Int, end: Int, dp: Array<IntArray>): Int {
        if (start > end) return 1

        var result = 0

        if (dp[start][end] != -1) {
            return dp[start][end]
        }
        for (i in start..end) {
            val left = bst(start, i - 1, dp)
            val right = bst(i + 1, end, dp)

            result += left * right
            dp[start][end] = result
        }

        return result
    }
}