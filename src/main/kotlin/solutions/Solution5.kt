package com.sobiroglu.solutions

class Solution5 {
    fun longestPalindrome(s: String): String {
        val n = s.length
        var start = 0
        var end = 0
        val dp = Array(n) { BooleanArray(n) { false }}

        for (len in 0 until n) {
            for (i in 0 until n - len) {
                dp[i][i + len] = s.get(i) == s.get(i + len) && (len < 2 || dp[i + 1][i + len - 1])
                if (dp[i][i + len] && len > end - start) {
                    start = i
                    end = i + len
                }
            }
        }

        return s.substring(start, end + 1)
    }
}
