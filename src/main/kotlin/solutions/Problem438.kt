package com.sobiroglu.solutions

class Problem438 {
    fun findAnagrams(s: String, p: String): List<Int> {
        var start = 0
        val freqs = IntArray(26) // frequencies
        val result = ArrayList<Int>()

        for (char in p.toCharArray()) {
            freqs[char - 'a']++
        }

        for (end in s.indices) {
            freqs[s[end] - 'a']--

            if (end - start == p.length - 1) {
                if (freqs.all { it == 0 }) {
                    result.add(start)
                }

                freqs[s[start] - 'a']++
                start++
            }
        }

        return result
    }

    /*fun findAnagrams(s: String, p: String): List<Int> {
        if (s.length < p.length) return emptyList()

        var start = 0
        val result = mutableListOf<Int>()

        for (end in p.length - 1 until s.length) {
            if (areTheyAnagrams(s.substring(start, end + 1), p)) {
                result.add(start)
            }
            start++
        }

        return result
    }

    fun areTheyAnagrams(subString: String, p: String): Boolean {
        val forSubstring = IntArray(26)
        val forP = IntArray(26)

        for (i in subString) {
            forSubstring[i - 'a']++
        }

        for (i in p) {
            forP[i - 'a']++
        }

        for (i in forSubstring.indices) {
            if (forSubstring[i] != forP[i]) return false
        }

        return true
    }*/
}