package com.sobiroglu.solutions

class Problem187 {
    fun findRepeatedDnaSequences(s: String): List<String> {
        if (s.length < 10) return emptyList()

        val set = HashSet<String>()
        val result = mutableSetOf<String>()

        var start = 0
        var end = 10

        while (end <= s.length) {
            /*if (set.contains(s.substring(start, end))) {
                result.add(s.substring(start, end))
            } else {
                set.add(s.substring(start, end))
            }*/

            if (!(set.add(s.substring(start, end)))) {
                result.add(s.substring(start, end))
            }

            start++
            end++
        }
        return result.toList()
    }
}