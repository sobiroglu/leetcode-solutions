package com.sobiroglu.solutions.july

/** Bottom-Up DP (Tabulation)
 *
 * Create a dp array where tabulation[i] is the minimum jumps to reach the end from index `i`.
 * Start from the end (tabulation[n-1] = 0) — because we need 0 jumps from the end to the end.
 * Move backward and for each index, try all the possible jumps and fill in the smallest number of jumps.
 *
 * */
class Solution0045_3 {
    fun jump(nums: IntArray): Int {
        val tabulation = IntArray(nums.size) { Integer.MAX_VALUE  }
        tabulation[nums.size - 1] = 0

        for (i in nums.size - 2 downTo 0) {
            for (j in 1 .. nums[i]) {
                if (i + j < nums.size && tabulation[i + j] != Integer.MAX_VALUE) {
                    tabulation[i] = minOf(tabulation[i], 1 + tabulation[i + j])
                }
            }
        }

        return tabulation[0]
    }
}

/**
 * class Solution45 {
 *     fun jump(nums: IntArray): Int {
 *         val n = nums.size
 *         val dp = IntArray(n) { 10001 } // A large number means unreachable
 *         dp[n - 1] = 0  // No jumps needed from the last index
 *
 *         for (i in n - 2 downTo 0) {
 *             for (j in 1..nums[i]) {
 *                 if (i + j < n) {
 *                     dp[i] = minOf(dp[i], 1 + dp[i + j])
 *                 }
 *             }
 *         }
 *
 *         return dp[0]
 *     }
 * }
 */