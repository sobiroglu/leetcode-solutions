package com.sobiroglu.solutions.july

/** brute-force solution */
class Solution0045 {
    fun jump(nums: IntArray): Int {
        val minimumJumps = IntArray(1) { Integer.MAX_VALUE }
        jumpTo(nums, 0, minimumJumps, 0)
        return if (minimumJumps[0] == Integer.MAX_VALUE) 0 else minimumJumps[0]
    }

    fun jumpTo(nums: IntArray, currentPos: Int, minimumJumps: IntArray, currentJumpCount: Int) {
        if (currentPos < nums.size - 1 && nums[currentPos] == 0) return

        if (currentPos >= nums.size - 1) {
            minimumJumps[0] = minOf(minimumJumps[0], currentJumpCount)
            return
        }

        for (i in 1..nums[currentPos]) {
            jumpTo(nums, currentPos + i, minimumJumps, currentJumpCount + 1)
        }
    }
}
