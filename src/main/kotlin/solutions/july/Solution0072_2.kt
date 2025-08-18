package com.sobiroglu.solutions.july

class Solution0072_2 {
    fun minDistance(word1: String, word2: String): Int {
        val word1len = word1.length
        val word2len = word2.length
        val tab = Array(word2len + 1) { IntArray(word1len + 1){ -1 } }

        for (i in 0..word1len) tab[0][i] = i
        for (i in 0..word2len) tab[i][0] = i

        for (i in 1..word2len) {
            for (j in 1..word1len) {
                if (word2[i - 1] == word1[j - 1]) {
                    tab[i][j] = tab[i - 1][j - 1]
                } else {
                    tab[i][j] = minOf(tab[i][j - 1], tab[i - 1][j], tab[i-1][j-1])
                }
            }
        }

        return tab[word2len][word1len]
    }
}