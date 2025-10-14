package com.sobiroglu.solutions.october

class Solution0213_2 {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        return maxOf(robPartial(0, nums.size - 2, nums), robPartial(1, nums.size - 1, nums))
    }

    fun robPartial(start: Int, end: Int, nums: IntArray): Int {
        var prevPrev = 0
        var prev = 0
        for (i in start .. end) {
            val currM = maxOf(prev, prevPrev + nums[i])
            prevPrev = prev
            prev = currM
        }
        return prev
    }
}