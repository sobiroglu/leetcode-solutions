package com.sobiroglu.solutions.july

class Solution0070_1 {
    fun climbStairs(n: Int): Int {
        if (n == 1 || n == 2) return n
        val tabulation = IntArray(n + 1)

        tabulation[1] = 1
        tabulation[2] = 2

        for (i in 3 .. n) {
            tabulation[i] = tabulation[i - 1] + tabulation[i - 2]
        }

        return tabulation[n]
    }
}