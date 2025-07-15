package com.sobiroglu.solutions.july

class Solution0930 {
    fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
        return atMostK(nums, goal) - atMostK(nums, goal - 1)
    }

    fun atMostK(nums: IntArray, goal: Int): Int {
        var start = 0
        var count = 0
        var windowSum = 0

        for (end in 0 until nums.size) {
            windowSum += nums[end]

            while (windowSum > goal && start <= end) {
                windowSum -= nums[start++]
            }

            count += end - start + 1
        }
        return count
    }
}