package com.sobiroglu.solutions.october

class Solution0152_2 {
    fun maxProduct(nums: IntArray): Int {
        val tab = Array(nums.size) { Array<Int?>(2) { null } }

        tab[0][0] = nums[0] // max
        tab[0][1] = nums[0] // min
        var result = nums[0]

        for (i in 1 until nums.size) {
            val curr = nums[i]
            val prevMax = tab[i - 1][0]!!
            val prevMin = tab[i - 1][1]!!

            tab[i][0] = maxOf(curr, prevMax * curr, prevMin * curr)
            tab[i][1] = minOf(curr, prevMax * curr, prevMin * curr)

            result = maxOf(tab[i][0]!!, result)
        }
        return result
    }
}