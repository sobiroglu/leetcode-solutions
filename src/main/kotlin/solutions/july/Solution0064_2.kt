package com.sobiroglu.solutions.july

class Solution0064_2 {
    fun minPathSum(grid: Array<IntArray>): Int {
        val rowSize = grid.size
        val columnSize = grid[0].size
        val memoization = Array(rowSize) { IntArray(columnSize) }

        return findMinSumPath(memoization, grid, 0, 0)
    }

    fun findMinSumPath(memoization: Array<IntArray>, grid: Array<IntArray>, row: Int, column: Int): Int {
        if (memoization[row][column] != 0) return memoization[row][column]
        var minSum = Integer.MAX_VALUE

        if (row + 1 < grid.size) minSum =
            minOf(findMinSumPath(memoization, grid, row + 1, column) + grid[row][column], minSum)
        if (column + 1 < grid[0].size) minSum =
            minOf(findMinSumPath(memoization, grid, row, column + 1) + grid[row][column], minSum)

        memoization[row][column] = if (minSum == Integer.MAX_VALUE) grid[row][column] else minSum
        return memoization[row][column]
    }
}