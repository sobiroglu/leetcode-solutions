package com.sobiroglu.solutions.october

class Solution0241_1 {
    fun diffWaysToCompute(expression: String): List<Int> {
        return calculateSubExpression(0, expression.length - 1, expression)
    }

    private fun calculateSubExpression(l: Int, r: Int, e: String): List<Int> {
        if (l == r) return listOf(e[l].toString().toInt())
        if (r - l == 1 && e[r] >= '0' && e[r] <= '9' && e[l] >= '0' && e[l] <= '9')
            return listOf(e.substring(l, r + 1).toString().toInt())

        val list = mutableListOf<Int>()
        for (i in l..r) {
            if (e[i] == '+' || e[i] == '-' || e[i] == '*') {
                val leftPart = calculateSubExpression(l, i - 1, e)
                val rightPart = calculateSubExpression(i + 1, r, e)

                // merge together left and right parts
                for (k in leftPart) {
                    for (m in rightPart) {
                        when (e[i]) {
                            '+' -> list.add(k + m)
                            '-' -> list.add(k - m)
                            '*' -> list.add(k * m)
                        }
                    }
                }
            }
        }
        return list
    }
}