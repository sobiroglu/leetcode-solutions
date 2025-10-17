package com.sobiroglu.solutions.october

class Solution0221_2 {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        val tab = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) }
        var result = 0

        for (i in matrix.size - 1 downTo 0) {
            for (j in matrix[0].size - 1 downTo 0) {
                if (matrix[i][j] == '0') {
                    tab[i][j] = 0
                } else {
                    tab[i][j] = 1 + minOf(tab[i + 1][j], tab[i][j + 1], tab[i + 1][j + 1])
                }
                result = maxOf(result, tab[i][j])
            }
        }
        return result * result
    }
}