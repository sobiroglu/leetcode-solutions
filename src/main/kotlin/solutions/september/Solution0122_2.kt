package com.sobiroglu.solutions.september

/** Tabulation */
class Solution0122_2 {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) return 0

        var canBuy = 0
        var canSell = 0

        for (i in prices.size - 1 downTo 0) {
            canBuy = maxOf(-prices[i] + canSell, canBuy)
            canSell = maxOf(prices[i] + canBuy, canSell)
        }

        return canBuy
    }

    /*fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) return 0

        *//** (dp[i][0], dp[i][1]) = (mustSell, canBuy) *//*
        val dp = Array(prices.size + 1) { Array<Int?>(2) { null } }
        dp[prices.size][0] = 0
        dp[prices.size][1] = 0

        for (i in prices.size - 1 downTo 0) {
            dp[i][1] = maxOf(-prices[i] + dp[i + 1][0]!!, dp[i+1][1]!!)
            dp[i][0] = maxOf(prices[i] + dp[i + 1][1]!!, dp[i + 1][0]!!)
        }

        return dp[0][1]!!
    }*/
}

/**
 * each day you face 2 possible moods: either you're free to buy, or you're holding and need to decide about selling.
 * for each mode, you ask: "What's better: act today, or wait until tomorrow?"
 * acting today changes your mood (buy -> must sell later, sell -> can buy again)
 * waiting today keeps your mood the same but moves you one step closer to the end.
 *
 * if you write down the best possible profit for every (day, mood) pair, starting from the end back to the start,
 * so that by day 0 you know the best chain of buy/sell/skip actions.
 *
 * dp[i][1] = max profit starting at day i if you can BUY (i.e. you do NOT hold a stock at day i).
 * dp[i][0] = max profit starting at day i if you must SELL (i.e. you currently hold a stock).
 *
 * Got you bruh 🙌 I’ll write this like a **mini-guide** for your future self, based on all the pain we just went through 😂. Simple English, no fancy words, only clear steps.
 *
 * ---
 *
 * # 📘 Max Profit (LeetCode 122) — Tabulation DP Guide
 *
 * ## 1. Problem reminder
 *
 * You can **buy and sell stock many times**. But you can’t hold more than one share at a time.
 * Goal: find **max profit**.
 *
 * ---
 *
 * ## 2. Key idea: Track “holding” or “not holding”
 *
 * At every day you only care about **2 states**:
 *
 * * `buy = 1` → you are **free to buy** (you don’t have stock now).
 * * `buy = 0` → you are **holding stock** (you already bought, next move can be sell).
 *
 * So DP is:
 *
 * ```
 * dp[i][buy] = max profit starting from day i, if my state is "buy"
 * ```
 *
 * ---
 *
 * ## 3. Base case
 *
 * At the end (after last day, `i = n`):
 *
 * * If `buy=1` → profit = 0 (nothing left to buy).
 * * If `buy=0` → profit = 0 (can’t sell anymore, market closed).
 *
 * So:
 *
 * ```
 * dp[n][0] = 0
 * dp[n][1] = 0
 * ```
 *
 * ---
 *
 * ## 4. Transition (how we move)
 *
 * At day `i`, you look at **day i+1** (the future).
 *
 * ### Case 1: `buy = 1` (not holding now → can buy)
 *
 * * Option 1: **Buy today** → pay `prices[i]`, go to `dp[i+1][0]` (holding tomorrow).
 *   Profit = `-prices[i] + dp[i+1][0]`
 * * Option 2: **Skip** → stay free to buy tomorrow → `dp[i+1][1]`
 * * Take the max.
 *
 * ```
 * dp[i][1] = max(-prices[i] + dp[i+1][0], dp[i+1][1])
 * ```
 *
 * ---
 *
 * ### Case 2: `buy = 0` (holding now → can sell)
 *
 * * Option 1: **Sell today** → earn `prices[i]`, go to `dp[i+1][1]` (free tomorrow).
 *   Profit = `+prices[i] + dp[i+1][1]`
 * * Option 2: **Skip** → keep holding → `dp[i+1][0]`
 * * Take the max.
 *
 * ```
 * dp[i][0] = max(prices[i] + dp[i+1][1], dp[i+1][0])
 * ```
 *
 * ---
 *
 * ## 5. Final answer
 *
 * At day `0` we start with **no stock** (free to buy).
 * So answer is:
 *
 * ```
 * dp[0][1]
 * ```
 *
 * ---
 *
 * ## 6. How to think (intuition)
 *
 * * DP doesn’t ask “am I holding stock?” → it’s **already part of the state**.
 * * At each day you only choose between:
 *
 *   * Take action (buy/sell)
 *   * Skip (copy tomorrow’s value)
 * * That’s it. Every decision is local (today vs tomorrow).
 *
 * ---
 *
 * ## 7. Example walk (prices = \[7,1,5,3,6,4])
 *
 * At last index + 1 (i=6):
 *
 * ```
 * dp[6][0] = 0
 * dp[6][1] = 0
 * ```
 *
 * At i=5 (price = 4):
 *
 * * `buy=1`: max(-4 + dp\[6]\[0], dp\[6]\[1]) = max(-4+0, 0) = 0
 * * `buy=0`: max(4 + dp\[6]\[1], dp\[6]\[0]) = max(4+0, 0) = 4
 *
 * So:
 *
 * ```
 * dp[5][1] = 0
 * dp[5][0] = 4
 * ```
 *
 * 👉 That means:
 *
 * * If I arrive at day 5 free to buy, best profit = 0 (skip).
 * * If I arrive at day 5 holding, best profit = 4 (sell).
 *
 * And you keep filling backward.
 *
 * ---
 *
 * ## 8. Common mistakes
 *
 * 1. Wrong sign:
 *
 *    * Buy = `-prices[i]`
 *    * Sell = `+prices[i]`
 * 2. Returning wrong answer: should be `dp[0][1]` (not max of both).
 * 3. Confusing “skip”: it just means **copy tomorrow’s dp** with same state.
 *
 * ---
 *
 * ⚡ That’s it. If you come back later and re-read:
 *
 * * Remember: **state = holding or not holding**.
 * * **Buy = -prices\[i]**, **Sell = +prices\[i]**.
 * * **Skip = dp\[i+1]\[same state]**.
 *
 * ---
 *
 * Do you want me to actually **draw the full 2D DP table for \[7,1,5,3,6,4]** so you can see numbers filling day by day?
 *
 */