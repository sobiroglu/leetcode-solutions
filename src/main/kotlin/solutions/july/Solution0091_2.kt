package com.sobiroglu.solutions.july

/** dp (memoization) iterative */
class Solution0091_2 {
    fun numDecodings(s: String): Int {
        val tab = IntArray(s.length + 1)
        tab[0] = 1
        tab[1] = if (s.first() != '0') 1 else 0

        for (i in 2 until tab.size) {
            val a = if (s[i - 1] in '1'..'9') tab[i - 1] else 0
            val b = if (s.substring(i - 2, i).toInt() in 10 .. 26) tab[i - 2] else 0

            tab[i] = a + b
        }

        return tab[tab.size - 1]
    }
}