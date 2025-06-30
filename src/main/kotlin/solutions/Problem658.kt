package com.sobiroglu.solutions

import kotlin.math.abs

class Problem658 {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        var start = 0
        var end = arr.size - 1
        val res = mutableListOf<Int>()

        while (end - start + 1 > k && end < arr.size) {
            if (abs(arr[start] - x) < abs(arr[end] - x)) {
                end--
                continue
            }

            if (abs(arr[start] - x) == abs(arr[end] - x) && arr[start] < arr[end]) {
                end--
                continue
            }

            start++
        }
        for (i in start..end) {
            res.add(arr[i])
        }

        return res
        //return arr.copyOfRange(start, end + 1).toList() don't use it. it takes long time
    }
}