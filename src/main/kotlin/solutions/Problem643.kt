package com.sobiroglu.solutions

class Problem643 {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var windowSum = 0L

        for (i in 0 until k) {
            windowSum += nums[i]
        }

        var result = windowSum

        for (end in k until nums.size) {
            windowSum += nums[end] - nums[end - k]
            result = maxOf(result, windowSum)
        }

        return result.toDouble() / k
    }

    /*fun findMaxAverage(nums: IntArray, k: Int): Double {
        var start = 0
        var windowSum = 0.0
        var result = Double.NEGATIVE_INFINITY

        for (end in nums.indices) {
            windowSum += nums[end]

            if (end - start + 1 == k) {
                result = maxOf(result, windowSum)
                windowSum -= nums[start++]
            }
        }

        return result / k
    }*/
}