package com.sobiroglu.solutions.september

/**
 * DFS with Memoization
 */
class Solution0097_1 {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        if (s1.length + s2.length != s3.length) return false
        val memo = Array(s3.length + 1) { Array<Boolean?>(s3.length + 1) { null } }
        return dfs(s1, s2, s3, 0, 0, memo)
    }

    fun dfs(s1: String, s2: String, s3: String, i: Int, j: Int, memo: Array<Array<Boolean?>>): Boolean {
        if (memo[i][j] != null) return memo[i][j]!!

        if (i == s1.length && j == s2.length) return true

        val first = if (i < s1.length && s1[i] == s3[i + j]) dfs(s1, s2, s3, i + 1, j, memo) else false
        val second = if (j < s2.length && s2[j] == s3[i + j]) dfs(s1, s2, s3, i, j + 1, memo) else false

        memo[i + 1][j] = first
        memo[i][j + 1] = second

        return first || second
    }
}