package com.sobiroglu.solutions.september

/** memoization */
class Solution0120_1 {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val rowSize = triangle.size
        val lastColumnSize = triangle[rowSize - 1].size

        val memo = Array(rowSize) { Array<Int?>(lastColumnSize) { null } }
        return findPath(triangle, 0, 0, memo)
    }

    private fun findPath(triangle: List<List<Int>>, row: Int, column: Int, memo: Array<Array<Int?>>): Int {
        if (row == triangle.size - 1) return triangle[row][column]
        if (memo[row][column] != null) return memo[row][column]!!

        val left = findPath(triangle, row + 1, column, memo)
        val right = findPath(triangle, row + 1, column + 1, memo)

        memo[row][column] = triangle[row][column] + minOf(left, right)
        return memo[row][column]!!
    }
}

/*class Solution0120_1 {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        return findPath(triangle, 0, 0, triangle[0][0])
    }

    private fun findPath(triangle: List<List<Int>>, row: Int, column: Int, currItem: Int): Int {
        if (row == triangle.size - 1) return currItem

        val left = findPath(triangle, row + 1, column, triangle[row + 1][column])
        val right = findPath(triangle, row + 1, column + 1, triangle[row + 1][column + 1])

        return currItem + minOf(left, right)
    }
}*/

