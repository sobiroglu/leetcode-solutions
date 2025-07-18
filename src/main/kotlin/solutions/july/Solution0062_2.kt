package com.sobiroglu.solutions.july

class Solution0062_2 {
    fun uniquePaths(m: Int, n: Int): Int {
        val memoization = Array(m) { IntArray(n) { -1 }}
        return countMoves(memoization, 0, 0)
    }

    fun countMoves(memoization: Array<IntArray>, row: Int, column: Int): Int {
        if (row == memoization.size - 1 || column == memoization.firstOrNull()?.size?.minus(1))
            return 1
        if (memoization[row][column] != -1) return memoization[row][column]

        memoization[row][column] = countMoves(memoization, row + 1, column) + countMoves(memoization, row, column + 1)
        return memoization[row][column]
    }
}