package com.sobiroglu.solutions.july

class Solution0072_1 {
    fun minDistance(word1: String, word2: String): Int {
        val memo = Array(word1.length + 1) { IntArray(word2.length + 1){ -1 } }
        return execute(word1, word2, 0, 0, memo)
    }

    private fun execute(word1: String, word2: String, word1Index: Int, word2Index: Int, memo: Array<IntArray>): Int {
        if (memo[word1Index][word2Index] != -1) return memo[word1Index][word2Index]

        if (word1Index >= word1.length) return word2.length - word2Index
        if (word2Index >= word2.length) return word1.length - word1Index

        if (word1[word1Index] == word2[word2Index]) {
            return execute(word1, word2, word1Index + 1, word2Index + 1, memo)
        }

        val delete = 1 + execute(word1, word2, word1Index + 1, word2Index, memo)
        val insert = 1 + execute(word1, word2, word1Index, word2Index + 1, memo)
        val modify = 1 + execute(word1, word2, word1Index + 1, word2Index + 1, memo)

        val result = minOf(delete, insert, modify)
        memo[word1Index][word2Index] = result
        return result
    }
}