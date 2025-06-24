package com.sobiroglu.solutions

class Problem3 {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0
        if (s.length == 1) return 1

        var startPointer = 0
        var endPointer = 1
        var maxLength = 1

        val window = mutableSetOf<Char>()
        window.add(s[0])

        while (endPointer < s.length) {
            if (window.contains(s[endPointer])) {
                if (window.size > maxLength) maxLength = window.size

                while (window.contains(s[endPointer])) {
                    window.remove(s[startPointer])
                    startPointer++
                }

                if (s[endPointer - 1] != s[endPointer]) window.add(s[endPointer - 1])
            } else {
                window.add(s[endPointer])
                endPointer = endPointer + 1
            }
        }

        if (window.isNotEmpty() && window.size > maxLength) maxLength = window.size

        return maxLength
    }
}