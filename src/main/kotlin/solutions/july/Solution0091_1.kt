package com.sobiroglu.solutions.july

/** dp (memoization) recursive */
class Solution0091_1 {
    fun numDecodings(s: String): Int {
        val memo = IntArray(s.length) { -1 }
        return findPath(0, s, memo)
    }

    private fun findPath(currentIndex: Int, s: String, memo: IntArray): Int {
        if (currentIndex == s.length) return 1
        if (s[currentIndex] == '0') return 0

        if (memo[currentIndex] != -1) return memo[currentIndex]

        val one = findPath(currentIndex + 1, s, memo)
        var two = 0
        if (currentIndex + 2 <= s.length && s.substring(currentIndex, currentIndex + 2).toIntOrNull()!! <= 26)
            two = findPath(currentIndex + 2, s, memo)

        memo[currentIndex] = one + two
        return one + two
    }
}