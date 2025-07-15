package com.sobiroglu.solutions.july

/** Top-Down DP (Memoization)
 *
 * Use a `memoization` array where memoization[i] is the minimum jumps needed from index `i` to the end.
 * If we’ve already calculated memoization[i], just return it.
 * Otherwise, try every possible jump from that position and pick the best (smallest number of jumps).
 *
 * */
class Solution0045_2 {
    fun jump(nums: IntArray): Int {
        val memoization = IntArray(nums.size) { -1 }
        return jumpTo(nums, 0, memoization)
    }

    fun jumpTo(nums: IntArray, currentPos: Int, memoization: IntArray): Int {
        if (currentPos >= nums.size - 1) return 0  // Reached or passed end

        if (nums[currentPos] == 0) return Integer.MAX_VALUE  // Can't move from here

        if (memoization[currentPos] != -1) return memoization[currentPos] // Already solved

        var minJumps = Integer.MAX_VALUE
        for (stepLength in 1 .. nums[currentPos]) {
            // asking: from currentPos, what is the minimum number of jumps I need to reach the end?
            val subJumps = jumpTo(nums, currentPos + stepLength, memoization)
            // subJum - tupik yol bolmasa (tupik yol boganda max value qaytaradi)
            if (subJumps != Int.MAX_VALUE) {
                minJumps = minOf(minJumps, 1 + subJumps)
            }
        }

        memoization[currentPos] = minJumps
        return minJumps
    }
}

/**
 * class Solution45 {
 *     fun jump(nums: IntArray): Int {
 *         val dp = IntArray(nums.size) { -1 }  // -1 means not calculated yet
 *         return helper(nums, 0, dp)
 *     }
 *
 *     fun helper(nums: IntArray, pos: Int, dp: IntArray): Int {
 *         if (pos >= nums.size - 1) return 0  // Reached or passed end
 *
 *         if (nums[pos] == 0) return 10001  // Can't move from here
 *
 *         if (dp[pos] != -1) return dp[pos]  // Already solved
 *
 *         var minJumps = 10001
 *         for (i in 1..nums[pos]) {
 *             val jumps = 1 + helper(nums, pos + i, dp)
 *             minJumps = minOf(minJumps, jumps)
 *         }
 *
 *         dp[pos] = minJumps
 *         return dp[pos]
 *     }
 * }
 */