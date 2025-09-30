package com.sobiroglu.solutions.september

class Solution1876 {
    fun countGoodSubstrings(s: String): Int {
        if (s.length < 3) return 0
        var counter = 0
        for (start in 0 .. s.length - 3) {
            val cur = s.substring(start, start + 3)
            if (allDifferent(cur)) counter++
        }
        return counter
    }

    private fun allDifferent(s: String): Boolean {
        return s[0] != s[1] && s[0] != s[2] && s[1] != s[2]
    }
}