package com.sobiroglu.solutions.september

import java.io.File

class Solution0509_1 {
    fun fib(n: Int): Int {
        val currentDir = System.getProperty("user.dir")
        val outputFile = File(currentDir, "display_runtime.txt")
        outputFile.writeText("0")

        if (n < 2) return n

        var prevPrev = 0
        var prev = 1
        var temp = 0

        for (i in 2 .. n) {
            temp = prev
            prev += prevPrev
            prevPrev = temp
        }

        return prev
    }
}