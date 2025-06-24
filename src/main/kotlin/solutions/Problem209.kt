package com.sobiroglu.solutions

class Problem209 {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var startPointer = 0
        var endPointer = 0
        var windowSum = 0
        var minRange = Integer.MAX_VALUE

        while (endPointer < nums.size || windowSum >= target) {
            if (windowSum < target) {
                windowSum += nums[endPointer]
                endPointer++
                continue
            }

            while (windowSum >= target) {
                if (endPointer - startPointer < minRange) minRange = endPointer - startPointer

                windowSum -= nums[startPointer]
                startPointer++
            }
        }
        return if (minRange == Integer.MAX_VALUE) 0 else minRange
    }
    /**
     * fun minSubArrayLen(target: Int, nums: IntArray): Int {
     *         var ml = Int.MAX_VALUE
     *         var l = 0
     *         var sum = 0
     *         for(r in nums.indices) {
     *             sum += nums[r]
     *             while(sum >= target) {
     *                 ml = minOf(ml, r-l+1)
     *                 sum -= nums[l]
     *                 l += 1
     *             }
     *         }
     *         return if(ml == Int.MAX_VALUE) 0 else ml
     *     }
     */

    /**fun minSubArrayLen(target: Int, nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var startPointer = 0
        var endPointer = 0
        var windowSum = 0
        var minRange = Integer.MAX_VALUE

        while (endPointer < nums.size || windowSum >= target) {
            // if windowSum is less than target then move window's endPointer to right
            // else move window's startPointer to the right till the sum is less than target

            if (windowSum < target) {
                windowSum += nums[endPointer]
                endPointer++
            } else {
                windowSum -= nums[startPointer]
                startPointer++

                if (endPointer - startPointer + 1 < minRange) minRange = endPointer - startPointer + 1
            }
        }
        return if (minRange == Integer.MAX_VALUE) 0 else minRange
    }*/
}