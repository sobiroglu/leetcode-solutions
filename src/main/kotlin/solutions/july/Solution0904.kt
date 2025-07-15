package com.sobiroglu.solutions.july

class Solution0904 {
    fun totalFruit(fruits: IntArray): Int {
        var start = 0
        val map = HashMap<Int, Int>()
        var result = 0

        for (end in 0 until fruits.size) {
            val element = fruits[end]
            if (map.contains(element)) map.put(element, map[element]!! + 1) else map.put(element, 1)

            if (map.keys.size > 2) {
                while (map.keys.size > 2) {
                    val treeType = fruits[start]
                    if (map[treeType]!! > 1) map.put(treeType, map[treeType]!! - 1) else map.remove(treeType)
                    start++
                }
            }

            result = maxOf(end - start + 1, result)
        }

        return result
    }
}