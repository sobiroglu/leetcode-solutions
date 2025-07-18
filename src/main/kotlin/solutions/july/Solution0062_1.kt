package com.sobiroglu.solutions.july

class Solution0062_1 {
    fun uniquePaths(m: Int, n: Int): Int {
        val tabulation = Array(m) { IntArray(n) { 1 }}
        //tabulation[m - 1][n - 1] = 0

        for (i in m - 2 downTo 0) {
            for (j in n - 2 downTo 0) {
                tabulation[i][j] = tabulation[i+1][j] + tabulation[i][j+1]
            }
        }

        return tabulation[0][0]
    }
}