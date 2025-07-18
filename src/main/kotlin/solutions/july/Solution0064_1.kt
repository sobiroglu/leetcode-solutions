package com.sobiroglu.solutions.july

class Solution0064_1 {
    fun minPathSum(grid: Array<IntArray>): Int {
        val rowSize = grid.size
        val columnSize = grid[0].size
        val tabulation = Array(rowSize) { IntArray(columnSize) }

        for (row in rowSize - 1 downTo 0) {
            for (column in columnSize - 1 downTo 0) {
                var minSum = Integer.MAX_VALUE
                if (column + 1 < columnSize) {
                    minSum = minOf(grid[row][column] + tabulation[row][column + 1], minSum)
                }

                if (row + 1 < rowSize) {
                    minSum = minOf(grid[row][column] + tabulation[row + 1][column], minSum)
                }

                tabulation[row][column] = if (minSum == Integer.MAX_VALUE) grid[row][column] else minSum
            }
        }

        return tabulation[0][0]
    }
}