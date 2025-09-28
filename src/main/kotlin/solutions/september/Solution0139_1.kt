package com.sobiroglu.solutions.september

class Solution0139_1 {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val memo = IntArray(s.length) { -1 }
        return dfs(s, 0, wordDict.toHashSet(), memo)
    }

    private fun dfs(s: String, start: Int, dic: HashSet<String>, memo: IntArray): Boolean {
        if (start >= s.length) return true

        if (memo[start] != -1) return memo[start] == 1
        for (i in 0 until (s.length - start)) {
            if (!isValidSegment(s.substring(start, start + i + 1), dic)) continue
            val result = dfs(s, start + i + 1, dic, memo)

            if (result == true) memo[start] = 1
            if (result == true) return true
        }
        memo[start] = 0
        return false
    }

    private fun isValidSegment(s: String, dic: HashSet<String>): Boolean {
        return dic.contains(s)
    }
}