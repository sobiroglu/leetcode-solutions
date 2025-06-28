package com.sobiroglu.solutions

class Problem567 {
    fun checkInclusion(s1: String, s2: String): Boolean {
        var start = 0
        val freqs = IntArray(26)

        for (char in s1) {
            freqs[char - 'a']++
        }

        for (end in s2.indices) {
            freqs[s2[end] - 'a']--

            if (end - start == s1.length) {
                freqs[s2[start++] - 'a']++
            }

            if (freqs.all { it == 0 }) {
                return true
            }
        }

        return false
    }
}