package com.sobiroglu.solutions.september

import kotlin.math.abs

class Solution1652_1 {
    fun decrypt(code: IntArray, k: Int): IntArray {
        val size = code.size
        val res = IntArray(size) { 0 }
        if (k == 0) return res

        for (i in 0 until size) {
            if (k > 0) {
                for (m in i + 1 until i + 1 + k) {
                    res[i] += code[m % size]
                }
            }
            if (k < 0) {
                for (m in (i + k) % size + size until (i + k) % size + size + abs(k)) {
                    res[i] += code[m % size]
                }
            }
        }

        return res
    }
}