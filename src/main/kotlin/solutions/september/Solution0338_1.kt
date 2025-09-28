package com.sobiroglu.solutions.september

/** brute force */
class Solution0338_1<T> {
    fun countBits(n: Int): IntArray {
        val arr = IntArray(n + 1) { 0 }
        for (i in 0..n) arr[i] = i.bitCount()
        return arr
    }

    private fun Int.bitCount(): Int {
        var ret = 0
        for (p in 0 until 32) {
            ret += this.and(1.shl(p)).shr(p)
        }
        return ret
    }
}