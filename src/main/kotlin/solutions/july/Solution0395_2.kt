package com.sobiroglu.solutions.july

class Solution0395_2 {
    fun longestSubstring(s: String, k: Int): Int {
        var result = 0

        for (i in 1..getUniqueCharsCount(s)) {
            var start = 0
            var end = 0
            val frequency = IntArray(26)
            var uniqueChars = 0
            var containsAtLestK = 0

            while (end < s.length) {
                if (uniqueChars > i) {       // need to shrink
                    if (frequency[s[start] - 'a'] == 1) uniqueChars--
                    if (frequency[s[start] - 'a'] == k) containsAtLestK--
                    frequency[s[start] - 'a']--
                    start++
                } else {                     // need to expand
                    if (frequency[s[end] - 'a'] == 0) uniqueChars++
                    frequency[s[end] - 'a']++
                    if (frequency[s[end] - 'a'] == k) containsAtLestK++
                    end++
                }

                if (uniqueChars == i && uniqueChars == containsAtLestK) {
                    result = maxOf(result, end - start)
                }
            }
        }

        return result
    }

    fun getUniqueCharsCount(s: String): Int {
        var counter = 0
        val array = IntArray(26)
        for (i in s.toCharArray()) {
            if (array[i - 'a'] == 0) counter++
            array[i - 'a']++
        }
        return counter
    }
}