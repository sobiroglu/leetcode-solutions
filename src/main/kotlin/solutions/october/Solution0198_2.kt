package com.sobiroglu.solutions.october

sealed class Solution0198_2 {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        if (nums.size == 2) return maxOf(nums[1], nums[0])

        val tab = IntArray(nums.size) { 0 }

        tab[0] = nums[0]
        tab[1] = maxOf(tab[0], nums[1])
        for (i in 2 until nums.size) {
            tab[i] = maxOf(tab[i - 1], tab[i - 2] + nums[i])
        }

        return tab[nums.size - 1]
    }
}