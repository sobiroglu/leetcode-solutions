package com.sobiroglu.solutions.october

class Solution0221_1 {
    private var maxSquare = 0

    fun maximalSquare(matrix: Array<CharArray>): Int {
        val memo = Array(matrix.size) { Array<Int?>(matrix[0].size) { null } }
        findPath(0, 0, matrix, memo)
        return maxSquare * maxSquare
    }

    private fun findPath(i: Int, j: Int, matrix: Array<CharArray>, memo: Array<Array<Int?>>): Int {
        if (memo[i][j] != null) return memo[i][j]!!
        if (i == matrix.size - 1 && j == matrix[0].size - 1) {
            return if (matrix[i][j] == '1') 1 else 0
        }
        if (i == matrix.size - 1 || j == matrix[0].size - 1) {
            return if (matrix[i][j] == '1') 1 else 0
        }
        val curr = if (matrix[i][j] == '1') 1 else 0
        val right = findPath(i, j + 1, matrix, memo)
        val bottom = findPath(i + 1, j, matrix, memo)
        val dio = findPath(i + 1, j + 1, matrix, memo)

        memo[i][j] = curr + minOf(right, bottom, dio)
        maxSquare = maxOf(maxSquare, memo[i][j]!!)
        return memo[i][j]!!
    }
}