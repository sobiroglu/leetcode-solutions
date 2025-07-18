package com.sobiroglu.solutions.july

class Solution0070_3 {
    fun climbStairs(n: Int): Int {
        if (n <= 2) return n

        var num1 = 1
        var num2 = 2
        var cur = 0

        for (i in 3..n) {
            cur = num1 + num2
            num1 = num2
            num2 = cur
        }

        return cur
    }
}