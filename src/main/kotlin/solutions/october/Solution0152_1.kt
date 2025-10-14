package com.sobiroglu.solutions.october

/** brute-force solution */
class Solution0152_1 {
    fun maxProduct(nums: IntArray): Int {
        var result = -Int.MAX_VALUE
        var prod = 1
        for (i in 0 until nums.size) {
            prod = 1
            for (j in i until nums.size) {
                prod *= nums[j]
                result = maxOf(prod, result)
            }
        }
        return result
    }
}