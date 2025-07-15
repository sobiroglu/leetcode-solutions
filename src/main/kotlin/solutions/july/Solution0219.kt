package com.sobiroglu.solutions.july

import kotlin.math.abs

class Solution0219 {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        if (nums.size == 1) return false

        val set = mutableSetOf<Int>()
        var startIndicator = 0
        var endIndicator = 0

        while (endIndicator < nums.size) {
            if (!(set.add(nums[endIndicator]))) {
                while (nums[startIndicator] != nums[endIndicator]) {
                    startIndicator++
                }
                if (abs(endIndicator - startIndicator) <= k) return true
                startIndicator++
            }

            endIndicator++
        }

        return false
    }
}