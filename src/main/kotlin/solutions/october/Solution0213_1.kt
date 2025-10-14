package com.sobiroglu.solutions.october

class Solution0213_1 {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        val left = find(0, nums.size - 2, nums, Array<Int?>(nums.size) { null })
        val right = find(1, nums.size - 1, nums, Array<Int?>(nums.size) { null })
        return maxOf(left, right)
    }

    fun find(start: Int, end: Int, nums: IntArray, memo: Array<Int?>): Int {
        if (start > end) return 0
        if (memo[start] != null) return memo[start]!!
        var result = 0
        for (i in start .. end) {
            result = maxOf(result, find(i + 2, end, nums, memo) + nums[i])
        }
        memo[start] = result
        return result
    }
}