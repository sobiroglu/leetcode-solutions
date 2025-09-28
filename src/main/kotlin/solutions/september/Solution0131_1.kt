package com.sobiroglu.solutions.september

class Solution0131_1 {
    fun partition(s: String): List<List<String>> {
        return findSubString(s, 0)
    }

    private fun findSubString(str: String, layer: Int): ArrayList<ArrayList<String>> {
        if (str.isEmpty()) return arrayListOf(arrayListOf())
        val temp = ArrayList<ArrayList<String>>()
        for (i in 0 until str.length) {
            val subStr = str.take(i + 1)
            if (subStr.isPalindrome()) {
                val restPartitions = findSubString(str.substring(i + 1, str.length), layer + 1)
                for (i in restPartitions) {
                    val newList = ArrayList<String>()
                    newList.add(subStr)
                    newList.addAll(i)
                    temp.add(newList)
                }
            }
        }
        return temp
    }

    private fun String.isPalindrome(): Boolean {
        for (i in 0 until this.length.div(2)) {
            if (this[i] != this[this.length - 1 - i]) return false
        }
        return true
    }
}