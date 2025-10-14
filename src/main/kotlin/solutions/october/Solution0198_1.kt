package com.sobiroglu.solutions.october

/** Memoization */
class Solution0198_1 {
    fun rob(nums: IntArray): Int {
        val memo = Array<Int?>(nums.size) { null }
        return find(0, nums, memo)
    }

    fun find(start: Int, nums: IntArray, memo: Array<Int?>): Int {
        if (start >= nums.size) return 0
        if (memo[start] != null) return memo[start]!!
        var result = 0
        for (i in start until nums.size) {
            result = maxOf(result, find(i + 2, nums, memo) + nums[i])
        }
        memo[start] = result
        return result
    }
}