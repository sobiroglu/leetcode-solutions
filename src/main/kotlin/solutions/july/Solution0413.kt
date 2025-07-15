package com.sobiroglu.solutions.july

class Solution0413 {
    fun numberOfArithmeticSlices(nums: IntArray): Int {
        if (nums.size < 3) return 0

        var start = 0
        var end = 2
        var result = 0
        var difference = nums[1] - nums[0]

        while(end < nums.size) {
            if (nums[end] - nums[end - 1] != difference) {
                start = end - 1
                difference = nums[end] - nums[end - 1]
                continue
            }

            end++
            if (end - start >= 3) result = result + (end - start - 2)
        }

        return result
    }
}

/**
 * 1st - check length of the array for (size > 2)?. If expression not satisfied we return 0 immediately.
 * 2nd - we set start = 0 and end = 2. Calculate difference between 1st and 2nd element and save as variable
 * 3rd - we iterate elements till end of the length of the given array and on each iteration we check for:
 *      - nums[end] - nums[end - 1] != difference. this part of code we'll use 'return early' method
 *      if the expression satisfied we change the start. start = end - 1. and on this point we calculate
 *      difference again with nums[end] - nums[end -1]
 *
 *      - we expand the window end here and its be like [start; end). because if we increase window's end after
 *      the expression which we'll write to calculate result the last computation not happened. (then we should
 *      calculate last part outside the iterator, and it's going to be boiler plant code)
 *
 *      - if elements inside the window is more than or equal to 3 we calculate how many subarray's windows included
 *      in it. we use this formula: result = result + (end - start - 2)
 */

/**
 * Key Concepts
 * Sliding Window Technique:
 *
 * Maintains a window [left, right] representing the current arithmetic sequence
 *
 * Expands when the difference remains consistent
 *
 * Resets when a new difference is found
 *
 * Arithmetic Sequence Detection:
 * Tracks the common difference (diff) between consecutive elements
 *
 * Validates each new element maintains this difference
 *
 * Counting Logic:
 * For each valid window of length ≥ 3:
 *
 * Counts the base slice of length 3
 *
 * Adds all extended slices (length 4, 5,... up to current window length)
 *
 * Example Walkthrough
 * For input [1, 2, 3, 4, 5]:
 *
 * Initial diff = 1 (2-1)
 *
 * Window grows to include 3, 4, 5 (all maintaining diff=1)
 *
 * At each step:
 *
 * right=2: [1,2,3] → +1 (count=1)
 *
 * right=3: [1,2,3,4] → +1 (for [1,2,3,4]) +1 (for [2,3,4]) → count=3
 *
 * right=4: [1,2,3,4,5] → +1 (for [1,2,3,4,5]) +1 (for [2,3,4,5]) +1 (for [3,4,5]) → count=6
 *
 * Optimization Notes
 * Efficiency:
 *
 * Single pass through array: O(n) time complexity
 *
 * Constant space: O(1)
 *
 * Edge Cases Handled:
 * Short arrays (<3 elements) return 0 immediately
 *
 * Properly handles difference changes (e.g., [1,3,5,1,2,3])
 *
 * Mathematical Insight:
 *
 * The formula count += ((right - left) - (k - 1)) efficiently counts all possible subarrays ending at current position:
 *
 * For window length L, there are (L-2) new arithmetic slices
 *
 * Example: length 4 adds 2 new slices ([1,2,3,4] and [2,3,4])
 *
 * class Solution {
 *     fun numberOfArithmeticSlices(nums: IntArray): Int {
 *         if (nums.size < 3) return 0
 *
 *         var left = 0
 *         var count = 0
 *         val k = 3
 *         var diff = nums[1] - nums[0]
 *
 *         for (right in 2 until nums.size) {
 *
 *             if (nums[right] - nums[right - 1] != diff) {
 *                 diff = nums[right] - nums[right - 1]
 *                 left = right - 1
 *             }
 *
 *             if (right - left >= k - 1) {
 *                 count++
 *                 count += ((right - left) - (k - 1))
 *             }
 *         }
 *
 *         return count
 *     }
 * }
 */