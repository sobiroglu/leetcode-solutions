package com.sobiroglu.solutions.july

class Solution0070_2 {
    fun climbStairs(n: Int): Int {
        val memoization = IntArray(n + 1)
        return climb(memoization, n)
    }

    fun climb(memoization: IntArray, n: Int): Int {
        if (n < 0) return 0
        if (n == 0) return 1

        if (memoization[n] != 0) return memoization[n]
        memoization[n] = climb(memoization, n - 1) + climb(memoization, n - 2)

        return memoization[n]
    }
}