package com.sobiroglu.solutions.september

import java.util.HashSet

class Solution1763_1 {
    fun longestNiceSubstring(s: String): String {
        if (s.isEmpty() || s.length == 1) return ""
        val set = HashSet<Char>()
        for (char in s) set.add(char)

        for (i in 0 until s.length) {
            val item = s[i].code xor 32
            if (!set.contains(item.toChar())) {
                val left = longestNiceSubstring(s.substring(0, i))
                val right = longestNiceSubstring(s.substring(i + 1, s.length))

                return if (left.length > right.length) left else right
            }
        }
        return s
    }
}