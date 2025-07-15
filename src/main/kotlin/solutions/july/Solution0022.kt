package com.sobiroglu.solutions.july

class Solution0022 {
    /**
     * 1. add open parentheses if open parentheses < n
     * 2. add closed parentheses if closed parentheses < opened parentheses
     * 3. stop recursion if opened parentheses == closed parentheses == n
     */
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        backtrack(0, 0, n, "", result)
        return result
    }

    fun backtrack(opened: Int, closed: Int, n: Int, output: String, result: MutableList<String>) {
        if (closed == n && opened == n) {
            result.add(output)
            return
        }

        if (opened < n) {
            backtrack(opened + 1, closed, n, "$output(", result)
        }

        if (closed < opened) {
            backtrack(opened, closed + 1, n, "$output)", result)
        }
    }
}