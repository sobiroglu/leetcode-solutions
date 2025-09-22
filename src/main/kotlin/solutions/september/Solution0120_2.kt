package com.sobiroglu.solutions.september

/** Tabulation (bottom-up)
 *
 * Nice 👌 tabulation (bottom-up DP) is actually a perfect fit for this problem, and it will make your code much simpler than recursion + memoization. Let me give you a **roadmap** without code, just the thought process:
 *
 * ---
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
class Solution0120_2 {

}






























































//function minimumTotal(triangle):
//n = number of rows in triangle
//
//// Step 1: initialize dp with the last row
//dp = copy of triangle[n-1]
//
//// Step 2: work upward from second-last row to top
//for row from n-2 down to 0:
//for col from 0 to row:
//dp[col] = triangle[row][col] + min(dp[col], dp[col+1])
//
//// Step 3: answer is at the top
//return dp[0]
