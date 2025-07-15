package com.sobiroglu.solutions.july

class Solution0713 {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        if (k <= 1) return 0

        var start = 0
        var result = 0
        var multiplication = 1

        for (end in 0 until nums.size) {
            multiplication *= nums[end]

            while (multiplication >= k && start < nums.size) {
                multiplication /= nums[start++]
                continue
            }

            result = result + end - start + 1
        }
        return result
    }
}