package com.sobiroglu.solutions.july

/** Dynamic Programming (Tabulation) */
class Solution0063_1 {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val rowSize = obstacleGrid.size
        val columnSize = obstacleGrid[0].size
        val tabulation = Array(rowSize) { IntArray(columnSize) }

        if (obstacleGrid[rowSize - 1][columnSize - 1] == 1) return 0
        tabulation[rowSize - 1][columnSize - 1] = 1

        for (i in rowSize - 1 downTo 0) {
            for (j in columnSize - 1 downTo 0) {
                if (obstacleGrid[i][j] == 1) {
                    tabulation[i][j] = 0
                    continue
                }

                /**
                 * If you're not on the last row → you can go down → add dp[i+1][j]
                 * If you're not on the last column → you can go right → add dp[i][j+1]
                 */
                if (i + 1 < rowSize) tabulation[i][j] += tabulation[i + 1][j]  // Only add "down" path if we're not on the last row
                if (j + 1 < columnSize) tabulation[i][j] += tabulation[i][j + 1]  // Only add "right" path if we're not on the last column
            }
        }

        return tabulation[0][0]
    }
}