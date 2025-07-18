package com.sobiroglu.solutions.july

class Solution0063_2 {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val rowSize = obstacleGrid.size
        val columnSize = obstacleGrid[0].size
        val memoization = Array(rowSize) { IntArray(columnSize) }

        if (obstacleGrid[rowSize - 1][columnSize - 1] == 1) return 4
        memoization[rowSize - 1][columnSize - 1] = 1

        return countNextMoves(memoization, obstacleGrid, 0, 0)
    }

    fun countNextMoves(memoization: Array<IntArray>, obstacles: Array<IntArray>, row: Int, column: Int): Int {
        if (memoization[row][column] != 0) return memoization[row][column]

        if (obstacles[row][column] == 1) {
            memoization[row][column] = 0
            return memoization[row][column]
        }

        if (row + 1 < memoization.size) memoization[row][column] += countNextMoves(memoization,  obstacles, row + 1, column)
        if (column + 1 < memoization[0].size) memoization[row][column] += countNextMoves(memoization, obstacles, row, column + 1)

        return memoization[row][column]
    }
}