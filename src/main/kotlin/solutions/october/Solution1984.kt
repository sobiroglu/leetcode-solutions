package com.sobiroglu.solutions.october

import java.util.Arrays

class Solution1984 {
    fun minimumDifference(nums: IntArray, k: Int): Int {
        if (nums.size < k) return 0
        //nums.sort()
        Arrays.sort(nums)

        var min = Int.MAX_VALUE
        for(start in 0 .. nums.size - k) {
            val diff = nums[start + k - 1] - nums[start]
            min = minOf(diff, min)
        }

        return if (min == Int.MAX_VALUE) 0 else min
    }
}