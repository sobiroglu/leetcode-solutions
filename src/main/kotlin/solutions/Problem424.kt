package com.sobiroglu.solutions

class Problem424 {
    /**
     * Counts the most frequent character in the window.
     * Checks whether the number of characters to change (window size - maxCount) is within k.
     */
    fun characterReplacement(s: String, k: Int): Int {
        val frequency = IntArray(26)
        var start = 0
        var result = 0
        var maxCount = 0

        for (end in s.indices) {
            val currentCharacter = s[end] - 'A'
            frequency[currentCharacter]++
            maxCount = maxOf(maxCount, frequency[currentCharacter])

            //val windowSize = end - start + 1
            if (end - start + 1 - maxCount > k) {
                frequency[s[start] - 'A']--
                start++
            }

            result = maxOf(result, end - start + 1)
        }

        return result
    }
}

/**
 * This approach didn't work.
 *
 * because solution assumes that the window must start with a repeating character and resets the window when
 * mismatches exceed k. However, this logic fails in cases where it's more optimal to keep a non-majority character
 * and still achieve a valid replacement count — like replacing 'A' in "ABBB" to get "BBBB".
 *
 *     fun characterReplacement(s: String, k: Int): Int {
 *         var start = 0
 *         var end = 0
 *         var opportunity = k
 *         var result = 1
 *
 *         while (start + 1 < s.length && end < s.length - 1) {
 *             end++
 *             if (s[start] != s[end]) {
 *                 if (opportunity == 0) {
 *                     while (s[start] == s[start + 1]) {
 *                         start++
 *                         if (start == s.length - 1) break
 *                     }
 *                     start++
 *                     end = start
 *                     opportunity = k
 *                 } else {
 *                     opportunity--
 *                 }
 *             }
 *
 *             result = maxOf(result, end - start + 1)
 *         }
 *         return result
 *     }
 *
 *     solution: Instead of tracking specific characters, the standard solution keeps a sliding window
 *
 */