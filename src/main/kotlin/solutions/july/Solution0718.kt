package com.sobiroglu.solutions.july

class Solution0718 {
    fun findLength(nums1: IntArray, nums2: IntArray): Int {
        var result = 0
        for (i in 0 until nums1.size) {
            var start = i
            var end = i
            for (j in i until nums2.size + i) {
                if (j >= nums1.size) break
                if (nums1[j] != nums2[j - i]) {
                    start = j
                    end = j
                    continue
                }

                end++
                result = maxOf(result, end - start)
            }
        }

        for (i in 0 until nums2.size) {
            var start = i
            var end = i
            for (j in i until nums1.size + i) {
                if (j >= nums2.size) break
                if (nums2[j] != nums1[j - i]) {
                    start = j
                    end = j
                    continue
                }

                end++
                result = maxOf(result, end - start)
            }
        }

        return result
    }
}

/**
 * ### 📦 Code:
 *
 * ```kotlin
 * fun findLength(nums1: IntArray, nums2: IntArray): Int {
 *     var maxLen = 0
 *     val n = nums1.size
 *     val m = nums2.size
 *
 *     // Slide nums1 over nums2 and vice versa in one loop
 *     for (offset in -(m - 1) until n) {
 *         val startA = maxOf(0, offset)
 *         val startB = maxOf(0, -offset)
 *         val length = minOf(n - startA, m - startB)
 *
 *         var count = 0
 *         for (k in 0 until length) {
 *             if (nums1[startA + k] == nums2[startB + k]) {
 *                 count++
 *                 maxLen = maxOf(maxLen, count)
 *             } else {
 *                 count = 0
 *             }
 *         }
 *     }
 *
 *     return maxLen
 * }
 * ```
 *
 * ---
 *
 * ### 🧠 What's Actually Happening:
 *
 * #### `for (offset in -(m - 1) until n)`
 *
 * * We try **all possible alignments** between the two arrays.
 * * Offset means how much you shift `nums1` *relative* to `nums2`.
 * * Example:
 *
 *   * `offset = -2` → `nums2` starts *before* `nums1`
 *   * `offset = 0` → both arrays start together
 *   * `offset = 3` → `nums1` is ahead by 3 elements
 *
 * ---
 *
 * #### `val startA = maxOf(0, offset)`
 *
 * * This calculates the **starting index in nums1** based on the offset.
 * * If `offset` is negative, nums1 starts at index 0.
 * * If `offset` is positive, nums1 starts at that offset.
 *
 * ---
 *
 * #### `val startB = maxOf(0, -offset)`
 *
 * * Similarly, this is the **starting index in nums2**.
 * * If `offset` is positive, nums2 starts at 0.
 * * If `offset` is negative, nums2 starts ahead (because it’s been "slid to the right").
 *
 * ---
 *
 * #### `val length = minOf(n - startA, m - startB)`
 *
 * * This determines how many elements overlap at this alignment.
 * * We compare only the **overlapping window** of both arrays.
 *
 * ---
 *
 * #### The inner loop:
 *
 * ```kotlin
 * for (k in 0 until length) {
 *     if (nums1[startA + k] == nums2[startB + k]) {
 *         count++
 *         maxLen = maxOf(maxLen, count)
 *     } else {
 *         count = 0
 *     }
 * }
 * ```
 *
 * * Go through the current overlapping window.
 * * Compare each pair.
 * * If they match: increase the count of matching subarray length.
 * * If not: reset the count.
 * * Keep track of the **maximum match length** seen.
 *
 * ---
 *
 * ### 🤘 Final Result:
 *
 * * After trying **all possible alignments**, return `maxLen`.
 */

/**
 * ### 🔍 Hint for Sliding Window Approach:
 *
 * Think of aligning `nums1` and `nums2` in different ways (like sliding one array over the other), and for each alignment, **check the length of the longest matching subarray segment**.
 *
 * #### Steps to Guide Your Thinking:
 *
 * 1. Treat one array (say `nums1`) as fixed, and slide the other array (`nums2`) over it.
 * 2. For each offset (or alignment), determine how many elements match consecutively.
 * 3. Keep track of the **maximum** number of consecutive matching elements seen during any alignment.
 *
 * #### Visualization:
 *
 * Imagine overlapping like this:
 *
 * ```
 * nums1:       [1,2,3,2,1]
 * nums2: [3,2,1,4,7]
 *          ↑
 *       align here and compare
 * ```
 *
 * Try all possible relative alignments (from full left overlap to full right) and check each overlapping segment.
 *
 */