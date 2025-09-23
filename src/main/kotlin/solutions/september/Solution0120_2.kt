package com.sobiroglu.solutions.september

class Solution0120_2 {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val lastRowSize = triangle.last().size
        val dp = Array(lastRowSize) { 0 }

        for (i in 0 until dp.size) {
            dp[i] = triangle.last()[i]
        }

        for (i in triangle.size - 2 downTo 0) {
            for (j in 0 until  triangle[i].size) {
                dp[j] = triangle[i][j] + minOf(dp[j], dp[j + 1])
            }
        }

        return dp[0]
    }
}

/** Tabulation (bottom-up)
 *
 * ### 1. Core idea
 *
 * * In recursion, you ask: *“From (row, col), what’s the minimum path down?”*.
 * * In tabulation, you flip it: *“If I start at the bottom row and go up, what’s the minimum path cost to reach each cell?”*
 *
 * So instead of exploring downward, you build answers upward.
 *
 * ---
 *
 * ### 2. Start from the bottom
 *
 * * The minimum path sum for the last row is just the values themselves (base case).
 * * So you can initialize your DP with `triangle[lastRow]`.
 *
 * ---
 *
 * ### 3. Move row by row upward
 *
 * * For each cell `(row, col)`, the min path is:
 *
 *   ```
 *   triangle[row][col] + min(dp[col], dp[col+1])
 *   ```
 *
 *   where `dp` holds results for the row below.
 *
 * ---
 *
 * ### 4. Keep updating
 *
 * * After you compute a row, you can overwrite `dp` with the new row’s results.
 * * By the time you reach the top row, `dp[0]` holds the answer.
 *
 * ---
 *
 * ### 5. Complexity
 *
 * * **Time:** O(n²) (every element visited once).
 * * **Space:** O(n) if you only keep one row, O(n²) if you keep a full table.
 *
 * ---
 *
 * ### 6. Plan of attack
 *
 * 1. Copy the bottom row into a `dp` array.
 * 2. Iterate rows from `triangle.size - 2` down to `0`.
 * 3. For each element in that row, update `dp[col]` with `triangle[row][col] + min(dp[col], dp[col+1])`.
 * 4. At the end, `dp[0]` is the result.
 *
 * ---
 *
 * 👉 That’s the whole flow. Once you’ve walked through this idea, the actual code is \~6–8 lines and way cleaner than recursion.*
 *
 * */