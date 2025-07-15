package com.sobiroglu.solutions.july

class Solution0594 {
    fun findLHS(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        var result = 0

        for (i in nums) {
            map.put(i, (map[i] ?: 0) + 1)
        }

        for (left in map.keys) {
            map[left + 1]?.let { right ->
                result = maxOf(result, (map[left] ?: 0) + right)
            }
        }

        return result
    }

    // used sliding window
    /*fun findLHS(nums: IntArray): Int {
        nums.sort()

        var start = 0
        var result = 0
        for (end in nums.indices) {
            while (nums[end] - nums[start] > 1) {
                start++
            }

            if (nums[end] - nums[start] == 1) {
                result = maxOf(result, end - start + 1)
            }
        }

        return result
    }*/
}