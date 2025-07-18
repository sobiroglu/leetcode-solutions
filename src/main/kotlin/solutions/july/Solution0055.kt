package com.sobiroglu.solutions.july

class Solution0055 {
    fun canJump(nums: IntArray): Boolean {
        if (nums.size == 1) return true

        val dp = IntArray(nums.size) { -1 }
        dp[nums.size - 1] = 0

        for (i in nums.size - 2 downTo 0) {
            if (nums[i] == 0) dp[i] = -2
            for (move in 1..nums[i]) {
                if (dp[i + move] == -2) continue
                if (dp[i + move] == 1 || (i + move) == nums.size - 1) {
                    dp[i] = 1
                    break
                }
            }
        }

        return dp[0] == 1
    }
}